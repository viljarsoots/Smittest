package com.TireExhange.Smit;


import com.TireExhange.Smit.Dto.ContactInformationDto;
import com.TireExhange.Smit.Dto.TimeDto;
import com.TireExhange.Smit.Helper.Transformer;
import com.TireExhange.Smit.entity.ContactInformation;
import com.TireExhange.Smit.entity.LondonTime;
import com.TireExhange.Smit.entity.ManTime;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@CrossOrigin("*")
@RestController
public class APIController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Transformer transformer;

    private final Logger logger = LoggerFactory.getLogger(APIController.class);
    private static String url = "http://localhost:9004/api/v1/tire-change-times";
    private static String url2 = "http://localhost:9003/api/v1/tire-change-times";

    @GetMapping(value = "/times/{from}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TimeDto> getTimes(@PathVariable("from") String from) throws ParseException {
        List<TimeDto> times = new ArrayList<>();
        String variable = String.format("?from=%s", from);
        ManTime[] jTimes = restTemplate.getForObject(url + variable, ManTime[].class);
                //return Arrays.asList(jTimes);
                for(int i = 0; i < jTimes.length;i++){
                    ManTime manTime = new ManTime(jTimes[i].getId(),
                            jTimes[i].getTime(),
                            jTimes[i].isAvailable());
                    if(manTime.isAvailable())
                        times.add(transformer.manTimeToDto(manTime));
                }
        return times;
    }
    @GetMapping(value = "/times/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TimeDto> getTimes(@PathVariable("from") String from, @PathVariable("to") String to) {
        List<TimeDto> times = new ArrayList<>();
        String variables = String.format("/available?from=%s&until=%s", from, to);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(url2 + variables);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("availableTime");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    LondonTime time = new LondonTime(
                            elem.getElementsByTagName("uuid").item(0).getTextContent(),
                            elem.getElementsByTagName("time").item(0).getTextContent());
                    times.add(transformer.londonTimeToDto(time));
                }
            }
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return times;
    }
    @PutMapping(value = "/manchester/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public   void bookManTime(@PathVariable("id") int id, @RequestBody String contactInformation){
        String variable = String.format("/%s/book", id);

        restTemplate.put(url + variable, contactInformation);

    }
    @PutMapping(value = "/london/{id}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public void bookTime(@PathVariable("id") String id, @RequestBody String jsonInput) throws JsonProcessingException {
        String variable = String.format("/%s/book", id);
        ObjectMapper jsonMapper = new ObjectMapper();
        ContactInformation contactInformation = jsonMapper.readValue(jsonInput, ContactInformation.class);
        XmlMapper xmlMapper = new XmlMapper();
        System.out.println(xmlMapper.writeValueAsString(contactInformation));
        restTemplate.put(url2 + variable, xmlMapper);

    }


}

package com.TireExhange.Smit.Helper;

import com.TireExhange.Smit.Dto.ContactInformationDto;
import com.TireExhange.Smit.Dto.TimeDto;
import com.TireExhange.Smit.entity.ContactInformation;
import com.TireExhange.Smit.entity.LondonTime;
import com.TireExhange.Smit.entity.ManTime;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class Transformer {

//    @Autowired
//    private APIController apiController;

    public TimeDto manTimeToDto(ManTime manTime) throws ParseException {
        TimeDto timeDto = new TimeDto();
            timeDto.setId(manTime.getId());
            timeDto.setTime(manTime.getTime());
            timeDto.setLocation("14 Bury New Rd, Manchester");
            timeDto.setCarType("Truck & Passenger car");
        return timeDto;
    }

    public TimeDto londonTimeToDto(LondonTime londonTime) throws ParseException {
        TimeDto timeDto = new TimeDto();
        timeDto.setId(londonTime.getUuid());
        timeDto.setTime(LondonTime.getTime());
        timeDto.setLocation("1A Gunton Rd, London");
        timeDto.setCarType("Car");
        return timeDto;
    }

    public ContactInformation contactInformationDtoToContactInfo(ContactInformationDto contactInformationDto){
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setContactInformation(contactInformationDto.getContactInformation());
        return contactInformation;
    }



}

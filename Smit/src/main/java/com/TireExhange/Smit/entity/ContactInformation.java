package com.TireExhange.Smit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.boot.jackson.JsonComponent;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonComponent
@JacksonXmlRootElement(namespace = "london.tireChangeBookingRequest")
public class ContactInformation {



    @JacksonXmlProperty(localName = "contactInformation")
    @JsonProperty("contactInformation")
    private String contactInformation;

    public ContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public ContactInformation() {

    }

    public String getContactInformation(ContactInformation contactInformation) {
        return this.contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}

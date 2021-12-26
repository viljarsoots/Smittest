package com.TireExhange.Smit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.springframework.boot.jackson.JsonComponent;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonComponent
public class ContactInformation {


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

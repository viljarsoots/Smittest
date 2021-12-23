package com.TireExhange.Smit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
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

package com.TireExhange.Smit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.springframework.boot.jackson.JsonComponent;

import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown=true)
public class ManTime {


    @JsonProperty("id")
    private String id;

    @JsonProperty("time")
    private String time;

    @JsonProperty("available")
    private boolean available;

    public ManTime(String id, String time, boolean available) {
        this.id = id;
        this.time = time;
        this.available = available;
    }

    public ManTime() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

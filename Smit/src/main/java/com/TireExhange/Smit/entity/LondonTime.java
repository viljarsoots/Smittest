package com.TireExhange.Smit.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown=true)
public class LondonTime {


    private String uuid;
    private static String time;
    //private boolean availableTime;

    public LondonTime(String uuid, String time) {
        this.uuid = uuid;
        this.time = time;

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public static String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

//    public boolean isAvailable() {
//        return availableTime;
//    }
//
//    public void setAvailable(boolean available) {
//        this.availableTime = available;
//    }
}

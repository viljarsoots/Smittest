package com.TireExhange.Smit.Dto;

import java.util.Date;

public class TimeDto {

    private String id;
    private String time;
    private String location;
    private String carType;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

        this.time = time.substring(11,16) + " " + time.substring(0,10);
    }
}

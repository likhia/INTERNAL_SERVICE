package com.workshop.main.service;


public class CarRegistration {

    private String model = null;
    private String color = null;
    private Integer engineCapacity = null;
    private String createdYear = null;
    private Boolean used  = null;
    private String type  = null;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(String createdYear) {
        this.createdYear = createdYear;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
    
}
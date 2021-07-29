package com.workshop.main.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

//import classes (1)
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Path("/service")
@Component
public class ServiceEndPoint {

    //Get URI from properties
    @Value("${common.uri}")
    private String commonURI; 

    @Value("${test}")
    private String test; 
    
    @POST
    @Path("/registervehicle")
    @Produces("application/json")
    public String registerVehicle(CarRegistration carInfo) {
        String plateNo = "UNASSIGNED";

        System.out.println("Test : " + test);
        System.out.println("Model : " + carInfo.getModel());
        System.out.println("Color : " + carInfo.getColor());
        System.out.println("Type : " + carInfo.getType());
        System.out.println("Engine Capacity : " + carInfo.getEngineCapacity());
        System.out.println("Created Year : " + carInfo.getCreatedYear());
        System.out.println("Used: " + carInfo.getUsed());

        //Invoke common webservice to get the car plate number based on Type attribute
        plateNo = getCarPlate(carInfo.getType());

        return plateNo;
    }
    
    //Invoke common service
    /**
     * Invoke common service to get the car plate no. 
     * @param type
     * @return car plate No
     */
    private String getCarPlate(String type) {

        String uri = "http://" + commonURI + "/api/common/carplate?type=" + type;

        System.out.println("URL: " + uri);

        RestTemplate restTemplate = new RestTemplate();
        
        return (String) restTemplate.getForObject(uri, String.class);
    }
}

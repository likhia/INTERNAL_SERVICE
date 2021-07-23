package com.workshop.main.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Path("/service")
@Component
public class ServiceEndPoint {

    @POST
    @Path("/registervehicle")
    @Produces("application/json")
    public String registerVehicle(CarRegistration carInfo) {
        String plateNo = "UNASSIGNED";

        System.out.println("Model : " + carInfo.getModel());
        System.out.println("Color : " + carInfo.getColor());
        System.out.println("Type : " + carInfo.getType());
        System.out.println("Engine Capacity : " + carInfo.getEngineCapacity());
        System.out.println("Created Year : " + carInfo.getCreatedYear());
        System.out.println("Used: " + carInfo.getUsed());

        return plateNo;
    }
}

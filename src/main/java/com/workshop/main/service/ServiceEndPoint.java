package com.workshop.main.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

//import classes (1)
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

//import classes (2)
import org.springframework.beans.factory.annotation.Autowired;
import com.workshop.main.entity.*;

@Path("/service")
@Component
public class ServiceEndPoint {

    //Get URI from properties
    @Value("${common.uri}")
    private String commonURI; 

    @Autowired
    private VehicleRepository repository;
    
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
        System.out.println("User: " + carInfo.getUser());

        //Invoke common webservice to get the car plate number based on Type attribute
        plateNo = getCarPlate(carInfo.getType());

        System.out.println("Saving");
        save(carInfo, plateNo);
        System.out.println("Saved");

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

    //Save new vehicle
    /**
     * Save new vehicle into database.
     * 
     * @param carInfo
     * @param carplate
     */
    private void save(CarRegistration carInfo, String carplate) {
        VehicleEntity vehicle = new VehicleEntity();

        vehicle.setCarplate(carplate);
        vehicle.setModel(carInfo.getModel());
        vehicle.setColor(carInfo.getColor());
        vehicle.setEngineCapacity(carInfo.getEngineCapacity());
        vehicle.setType(carInfo.getType());
        vehicle.setCreatedYear(carInfo.getCreatedYear());
        vehicle.setUser(carInfo.getUser());
        vehicle.setUsed(carInfo.getUsed().toString());

        repository.save(vehicle);
        Iterable<VehicleEntity> iter = repository.findAll();
        java.util.Iterator list = iter.iterator();
        while(list.hasNext()){ 
            VehicleEntity car = (VehicleEntity)list.next();
            System.out.println(car.getCarplate());
        }

    }
}

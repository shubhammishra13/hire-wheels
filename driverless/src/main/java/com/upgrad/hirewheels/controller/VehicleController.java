package com.upgrad.hirewheels.controller;


import com.upgrad.hirewheels.dto.AddVehicleDTO;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.responsemodel.VehicleDetailResponse;
import com.upgrad.hirewheels.service.UserService;
import com.upgrad.hirewheels.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    UserService userService;

    /**
     *
     * @param categoryName
     * @return
     */

    @GetMapping("/getAllVehicles/{categoryName}")
    public ResponseEntity getAvailableVehicles(@PathVariable String categoryName){
        List<VehicleDetailResponse> vehicleDetailResponse = vehicleService.getAvailableVehicles(categoryName);
        return ResponseEntity.ok(vehicleDetailResponse);
    }

    /**
     *
     * @param vehicle
     * @param userId
     * @return
     */

    @PostMapping("/addVehicle/{userId}")
    public ResponseEntity addVehicleRequest(@RequestBody AddVehicleDTO vehicle, @PathVariable int userId){
        String userRole = vehicle.getUserRole();
        Vehicle returnedVehicle = vehicleService.addVehicleRequest(vehicle,userId);
        System.out.println(returnedVehicle.getVehicleId()+ "added vehicle");
        if(!userRole.equals("Admin")){
            return ResponseEntity.ok("Vehicle Added Successfully. Waiting for Admin to Approve.");
        } else {
            return  ResponseEntity.ok("Vehicle Added Successfully.");
        }
    }

    @GetMapping("/getAllVehiclesByUser/{userId}")
    public ResponseEntity getVehicleByUserId(@PathVariable int userId){
        List<VehicleDetailResponse> vehicleDetailResponse = vehicleService.getAllVehicleByUserId(userId);
        return ResponseEntity.ok(vehicleDetailResponse);
    }

}

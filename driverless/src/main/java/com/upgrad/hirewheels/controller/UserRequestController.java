package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.OptVehicleDTO;
import com.upgrad.hirewheels.service.UserRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRequestController {

    @Autowired
    UserRequestService userRequestService;

    @PutMapping("/optVehicle/{vehicleId}")
    public ResponseEntity addVehicleRequest(@RequestBody OptVehicleDTO vehicle, @PathVariable int vehicleId) {
            userRequestService.userOptRequest(vehicle, vehicleId);
            return ResponseEntity.ok("Request successful. Kindly wait for Admin to approve.");
        }
    }



package com.upgrad.hirewheels.controller;


import com.upgrad.hirewheels.dto.OptVehicleDTO;
import com.upgrad.hirewheels.entities.AdminRequest;
import com.upgrad.hirewheels.service.AdminService;
import com.upgrad.hirewheels.service.UserRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserRequestService userRequestService;


    @GetMapping("/getAllApprovals/{requestId}")
    public ResponseEntity getVehicleByUserId(@PathVariable int requestId){
        List<AdminRequest> adminRequestList = adminService.getAllAdminRequest(requestId);
        return ResponseEntity.ok(adminRequestList);
    }

    @PutMapping("/updateApproval/{vehicleId}")
    public ResponseEntity addVehicleRequest(@RequestBody OptVehicleDTO vehicle, @PathVariable int vehicleId) {
        userRequestService.userOptRequest(vehicle, vehicleId);
        return ResponseEntity.ok("Request successful. Kindly wait for Admin to approve.");
    }
}

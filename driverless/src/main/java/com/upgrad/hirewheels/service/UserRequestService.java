package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dto.OptVehicleDTO;
import com.upgrad.hirewheels.entities.AdminRequest;


public interface UserRequestService{
AdminRequest userOptRequest(OptVehicleDTO vehicleDTO, int vehicleId);
}

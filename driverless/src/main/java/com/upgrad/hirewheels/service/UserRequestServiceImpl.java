package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dto.OptVehicleDTO;
import com.upgrad.hirewheels.entities.AdminRequest;
import com.upgrad.hirewheels.dao.AdminRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequestServiceImpl implements UserRequestService {

    @Autowired
    AdminRequestRepository adminRequestRepository;

    public AdminRequest userOptRequest(OptVehicleDTO vehicle, int vehicleId) {
        AdminRequest returnedVehicle =  adminRequestRepository.findByVehicleId(vehicleId);
        returnedVehicle.setActivityId(vehicle.getActivityId());
        returnedVehicle.setRequestStatusId(vehicle.getRequestStatusId());
        returnedVehicle.setUserComments(vehicle.getUserComments());
        adminRequestRepository.save(returnedVehicle);
        return returnedVehicle;
    }
}

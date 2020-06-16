package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dto.AddVehicleDTO;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.responsemodel.VehicleDetailResponse;

import java.util.List;

public interface VehicleService {
    List<VehicleDetailResponse> getAvailableVehicles(String categoryName);
    Vehicle addVehicleRequest(AddVehicleDTO vehicle, int userId);
    List<VehicleDetailResponse> getAllVehicleByUserId(int userId);
}

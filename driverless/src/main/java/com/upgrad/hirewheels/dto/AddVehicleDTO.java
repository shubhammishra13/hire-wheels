package com.upgrad.hirewheels.dto;

import lombok.Data;

@Data
public class AddVehicleDTO {
     String vehicleModel;
     String vehicleNumber;
     int vehicleCategoryId;
     String vehicleTypeName;
     String color;
     int costPerHour;
     int fuelTypeId;
     String locationName;
     String address;
     String carImageUrl;
     int pincode;
     int cityId;
     String userRole;
}

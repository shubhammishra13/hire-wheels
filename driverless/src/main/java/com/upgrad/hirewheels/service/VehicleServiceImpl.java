package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dto.AddVehicleDTO;
import com.upgrad.hirewheels.responsemodel.VehicleDetailResponse;
import com.upgrad.hirewheels.entities.*;
import com.upgrad.hirewheels.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleCategoryRepo vehicleCategoryRepo;

    @Autowired
    RequestStatusRepository requestStatusRepository;

    @Autowired
    AdminRequestRepository adminRequestRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    FuelTypeRepository fuelTypeRepository;

    @Autowired
    CityRepository cityRepository;



    public List<VehicleDetailResponse> getAvailableVehicles(String categoryName) {
        VehicleCategory vehicleCategory = vehicleCategoryRepo.findByVehicleCategoryName(categoryName);
        VehicleType vehicleType = vehicleTypeRepository.findByVehicleTypeId(vehicleCategory.getVehicleTypes().get(0).getVehicleTypeId());
        List<Vehicle> returnedVehicle= vehicleType.getVehicle();
//        List<Vehicle> returnedVehicle = vehicleRepository.findByVehicleTypeId(vehicleCategory.getVehicleTypes().get(0).getVehicleTypeId());
        List<Integer> requestStatuses = requestStatusRepository.findByRequestStatusName("APPROVED").stream().map(RequestStatus::getRequestStatusId).collect(Collectors.toList());
        List<Integer> approvedVehicles = adminRequestRepository.findByRequestStatusIdIn(requestStatuses).stream().map(AdminRequest::getVehicleId).collect(Collectors.toList());
        List<Booking> bookedVehicleDetails = bookingRepository.findByPickupDateGreaterThanEqual(new Date());
        List<VehicleDetailResponse> mapVehicle = new ArrayList<>();
        for (Vehicle v : returnedVehicle) {
            if (approvedVehicles.contains(v.getVehicleId())) {
                VehicleDetailResponse y = new VehicleDetailResponse();
                y.setVehicleId(v.getVehicleId());
                y.setVehicleModel(v.getVehicleModel());
                y.setVehicleOwner(v.getOwnerId());
                y.setVehicleNumber(v.getVehicleNumber());
                y.setColor(v.getColor());
                y.setCostPerHour(v.getVehicleType().getCostPerHour());
                y.setFuelType(v.getFuelType().getFuelType());
                y.setLocationId(v.getLocationWithVehicle().getLocationId());
                y.setLocationName(v.getLocationWithVehicle().getLocationName());
                y.setAddress(v.getLocationWithVehicle().getAddress());
                y.setPincode(v.getLocationWithVehicle().getPincode());
                y.setCarImageUrl(v.getCarImageUrl());
                y.setCityName(v.getLocationWithVehicle().getCity().getCityName());
                y.setBooking(bookedVehicleDetails.stream().filter(a -> a.getVehicleId() == y.getVehicleId()).collect(Collectors.toList()));
                mapVehicle.add(y);
            }
        }
       return mapVehicle;
    }

    public Vehicle addVehicleRequest(AddVehicleDTO vehicle, int userId) {
        Vehicle addVehicle = new Vehicle();
        AdminRequest adminRequest = new AdminRequest();
        String userRole = vehicle.getUserRole();
        addVehicle.setVehicleModel(vehicle.getVehicleModel());
        addVehicle.setOwnerId(userId);
        addVehicle.setVehicleNumber(vehicle.getVehicleNumber());
        addVehicle.setColor(vehicle.getColor());
        addVehicle.setFuelType(fuelTypeRepository.findByFuelTypeId(vehicle.getFuelTypeId()));
        addVehicle.setCarImageUrl(vehicle.getCarImageUrl());
        Location location = new Location();
        location.setAddress(vehicle.getAddress());
        location.setLocationName(vehicle.getLocationName());
        location.setPincode(vehicle.getPincode());
        location.setCity(cityRepository.findByCityId(vehicle.getCityId()));
        addVehicle.setLocationWithVehicle(location);
        addVehicle.setVehicleType(vehicleCategoryRepo.findByVehicleCategoryId(vehicle.getVehicleCategoryId()).getVehicleTypes().get(0));
        Vehicle returnedVehicle = vehicleRepository.save(addVehicle);
        if (!userRole.equals("Admin")) {
            adminRequest.setActivityId(204);
            adminRequest.setRequestStatusId(301);
            adminRequest.setUserId(returnedVehicle.getOwnerId());
            adminRequest.setUserComments("Kindly Approve My Vehicle.");
            adminRequest.setVehicleId(returnedVehicle.getVehicleId());
            adminRequestRepository.save(adminRequest);
        } else {
            adminRequest.setActivityId(204);
            adminRequest.setRequestStatusId(302);
            adminRequest.setUserId(returnedVehicle.getOwnerId());
            adminRequest.setUserComments("Approved as added by Admin");
            adminRequest.setVehicleId(returnedVehicle.getVehicleId());
            adminRequestRepository.save(adminRequest);
        }
        return returnedVehicle;
    }


    public List<VehicleDetailResponse> getAllVehicleByUserId(int userId) {
        List<VehicleDetailResponse> mapVehicle = new ArrayList<>();
        List<Vehicle> returnedVehicles = vehicleRepository.findByOwnerId(userId);
        List<Integer> requestStatuses = requestStatusRepository.findByRequestStatusName("APPROVED").stream().map(RequestStatus::getRequestStatusId).collect(Collectors.toList());
        List<Integer> approvedVehicles = adminRequestRepository.findByRequestStatusIdIn(requestStatuses).stream().map(AdminRequest::getVehicleId).collect(Collectors.toList());
        List<Booking> bookedVehicleDetails = bookingRepository.findByPickupDateGreaterThanEqual(new Date());
        for (Vehicle v : returnedVehicles) {
            if (approvedVehicles.contains(v.getVehicleId())) {
                VehicleDetailResponse y = new VehicleDetailResponse();
                y.setVehicleId(v.getVehicleId());
                y.setVehicleModel(v.getVehicleModel());
                y.setVehicleOwner(v.getOwnerId());
                y.setVehicleNumber(v.getVehicleNumber());
                y.setColor(v.getColor());
                y.setLocationName(v.getLocationWithVehicle().getLocationName());
                y.setAddress(v.getLocationWithVehicle().getAddress());
                y.setPincode(v.getLocationWithVehicle().getPincode());
                y.setCarImageUrl(v.getCarImageUrl());
                y.setCityName(v.getLocationWithVehicle().getCity().getCityName());
                y.setBooking(bookedVehicleDetails.stream().filter(a -> a.getVehicleId() == y.getVehicleId()).collect(Collectors.toList()));
                mapVehicle.add(y);
            }
        }
        return mapVehicle;
    }

}


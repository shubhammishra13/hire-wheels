package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
//    List<Vehicle> findByVehicleTypeId(int vehicleTypeId);
    List<Vehicle> findByOwnerId(int userId);
}

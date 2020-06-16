package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.AdminRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRequestRepository extends JpaRepository<AdminRequest, Integer> {
    List<AdminRequest> findByRequestStatusIdIn(List<Integer> requestStatusId);
    AdminRequest findByVehicleId(int vehicleId);
    List<AdminRequest> findByRequestStatusId(int requestStatus);
}

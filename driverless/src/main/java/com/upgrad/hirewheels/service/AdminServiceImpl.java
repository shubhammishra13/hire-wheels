package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entities.AdminRequest;
import com.upgrad.hirewheels.dao.AdminRequestRepository;
import com.upgrad.hirewheels.dao.RequestStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRequestRepository adminRequestRepository;

    @Autowired
    RequestStatusRepository requestStatusRepository;

    public List<AdminRequest> getAllAdminRequest(int requestStatus) {
        List<AdminRequest> approvedVehicles = adminRequestRepository.findByRequestStatusId(requestStatus);
        return approvedVehicles;
    }
}

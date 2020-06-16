package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entities.AdminRequest;

import java.util.List;

public interface AdminService {
    List<AdminRequest> getAllAdminRequest(int requestId);
}

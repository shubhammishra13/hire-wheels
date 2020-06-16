package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestStatusRepository extends JpaRepository<RequestStatus, Integer> {
    List<RequestStatus> findByRequestStatusName(String requestName);
}

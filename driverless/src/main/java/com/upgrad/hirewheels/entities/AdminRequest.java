package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="ADMINREQUEST")
public class AdminRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int requestId;
    int userId;
    int activityId;
    String userComments;
    String adminComments;
    int requestStatusId;
    int vehicleId;
}

package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="REQUESTSTATUS")
public class RequestStatus {
    @Id
    int requestStatusId;
    String requestStatusName;
}

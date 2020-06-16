package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="ACTIVITY")
public class Activity {
    @Id
    int activityId;
    String activityType;
}



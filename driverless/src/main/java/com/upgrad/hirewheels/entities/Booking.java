package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name="BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookingId;
    int userId;
    int vehicleId;
    Date pickupDate;
    Date dropoffDate;
    Date bookingDate;
    int locationId;
    int amount;
    int activityId;
}

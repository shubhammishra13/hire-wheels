package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="LOCATION")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int locationId;
    String locationName;
    String address;
    int pincode;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locationWithVehicle",cascade
            = CascadeType.ALL)
    List<Vehicle> vehicles;
    @ManyToOne(fetch = FetchType.LAZY)
    City city;
}

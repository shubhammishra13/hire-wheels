package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name= "FUELTYPE")
public class FuelType {
        @Id
        int fuelTypeId;
        String fuelType;
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "fuelType")
        List<Vehicle> vehicles;
}


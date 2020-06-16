package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="VEHICLE")
public class Vehicle {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int vehicleId;
   String vehicleModel;
   int ownerId;
   String vehicleNumber;
   String color;
   String carImageUrl;
   @ManyToOne(fetch = FetchType.LAZY,cascade
           = CascadeType.ALL)
   @JoinColumn(name = "vehicleTypeId")
   VehicleType vehicleType;
   @ManyToOne(fetch = FetchType.LAZY,cascade
           = CascadeType.ALL)
   @JoinColumn(name = "fuelTypeId")
   FuelType fuelType;
   @ManyToOne(fetch = FetchType.LAZY,cascade
           = CascadeType.ALL)
   @JoinColumn(name = "locationId")
   Location locationWithVehicle;
}

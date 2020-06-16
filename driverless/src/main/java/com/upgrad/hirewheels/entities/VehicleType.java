package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "VEHICLETYPE")
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vehicleTypeId;
    String vehicleTypeName;
    int costPerHour;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleType", cascade
            = CascadeType.ALL)
    List<Vehicle> vehicle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleCategoryId")
    VehicleCategory vehicleCategory;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleCategory")
//    List<VehicleCategory> vehicleCategoryList;
}

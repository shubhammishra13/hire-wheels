package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="VEHICLECATEGORY")
public class VehicleCategory {
    @Id
    int vehicleCategoryId;
    String vehicleCategoryName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleCategory")
    List<VehicleType> vehicleTypes;
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "vehicleCategoryId")
//    VehicleType vehicleTypes;
}

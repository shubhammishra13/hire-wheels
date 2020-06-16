package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="CITY")
public class City {
    @Id
    int cityId;
    String cityName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    List<Location> locations;
}


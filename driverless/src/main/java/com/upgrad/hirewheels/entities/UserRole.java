package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "USERROLE")
public class UserRole {
    @Id
    int roleId;
    String roleName;
    @OneToMany(fetch = FetchType.LAZY)
    List<Users> usersList;
}

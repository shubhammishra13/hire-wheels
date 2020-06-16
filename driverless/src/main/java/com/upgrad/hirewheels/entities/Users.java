package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String firstName;
    String lastName;
    String password;
    String email;
    long mobileNo;
    int walletMoney;
    @ManyToOne(fetch = FetchType.LAZY)
    UserRole userRole;
}

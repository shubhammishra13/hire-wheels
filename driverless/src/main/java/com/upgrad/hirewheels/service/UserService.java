package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.exceptions.UserServiceException;
import com.upgrad.hirewheels.entities.Users;


public interface UserService{
    Users getUserDetails(String Email, String Password) throws UserServiceException;
    Boolean createUser(Users user) throws UserServiceException;
    Boolean updatePassword(String email, long mobileNo, String password) throws UserServiceException;
}
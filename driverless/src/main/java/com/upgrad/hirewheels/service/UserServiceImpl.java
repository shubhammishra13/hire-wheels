package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.UserRoleRepository;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    public Users getUserDetails(String email, String password) {
            Users user = userRepository.findByEmailAndPassword(email, password);
            return user;
    }

    public Boolean createUser(Users user) {
            user.setUserRole(userRoleRepository.findByRoleId(2));
            Users savedUser = userRepository.save(user);
            return true;
    }

    public Boolean updatePassword(String email, long mobileNo, String password) {
            Users user = userRepository.findByEmailAndMobileNo(email,mobileNo);
            String currentPassword = user.getPassword();
            if(!currentPassword.equals(password)) {
                user.setPassword(password);
                userRepository.save(user);
                return true;
            } else {
                return false;
            }
    }

}

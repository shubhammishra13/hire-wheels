package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.ForgetPWDDTO;
import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.exceptions.UserServiceException;
import com.upgrad.hirewheels.responsemodel.UserDetailResponse;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController{

    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO user){
        ResponseEntity responseEntity = null;
        UserDetailResponse userDetailResponse = new UserDetailResponse();
        try {
            Users userDetail = userService.getUserDetails(user.getEmail(), user.getPassword());
            if (userDetail != null) {
                userDetailResponse.setUserId(userDetail.getUserId());
                userDetailResponse.setFirstName(userDetail.getFirstName());
                userDetailResponse.setLastName(userDetail.getLastName());
                userDetailResponse.setEmail(userDetail.getEmail());
                userDetailResponse.setMobileNumber(userDetail.getMobileNo());
                userDetailResponse.setWalletMoney(userDetail.getWalletMoney());
                userDetailResponse.setRoleName(userDetail.getUserRole().getRoleName());
                userDetailResponse.setSuccessMessage("User Successfully Logged In");
                responseEntity = ResponseEntity.ok(userDetailResponse);
            } else {
                userDetailResponse.setErrorMessage("Invalid UserName/Password");
                responseEntity =  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(userDetailResponse);
            }
        } catch (UserServiceException e){
                logger.error(e.getMessage());
//                userDetailResponse.setErrorMessage(e.getMessage());
//                responseEntity =  ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(userDetailResponse);
        }
        return responseEntity;
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody Users user) {
        ResponseEntity responseEntity = null;
        UserDetailResponse userDetailResponse = new UserDetailResponse();
        try {
            boolean functionReturn = userService.createUser(user);
            if (functionReturn == true) {
                userDetailResponse.setSuccessMessage("User Successfully Signed In");
                return ResponseEntity.ok(userDetailResponse);
            } else {
                userDetailResponse.setErrorMessage("Error Sign In");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(userDetailResponse);
            }
        }
        catch (UserServiceException e){
                logger.error(e.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/forget-pwd")
    public ResponseEntity forgetpassword(@RequestBody ForgetPWDDTO user) {
        ResponseEntity responseEntity = null;
        UserDetailResponse userDetailResponse = new UserDetailResponse();
        try {
            boolean functionReturn = userService.updatePassword(user.getEmail(), user.getMobileNo(), user.getPassword());

            if (functionReturn == true) {
                userDetailResponse.setSuccessMessage("Password updated successfully");
                return ResponseEntity.ok(userDetailResponse);
            } else {
                userDetailResponse.setErrorMessage("Error Updating Password");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(userDetailResponse);
            }
        } catch (UserServiceException e){
                logger.error(e.getMessage());
        }
        return responseEntity;
    }
}
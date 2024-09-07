package com.service.ServicePlatform.controller;

import com.service.ServicePlatform.dto.SignupRequestDTO;
import com.service.ServicePlatform.dto.UserDto;
import com.service.ServicePlatform.services.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/client/sign-up")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO){

        if (authService.presentByEmail(signupRequestDTO.getEmail())){
            return new ResponseEntity<>("This Email Has Already Used! Please Try Another One. ", HttpStatus.NOT_ACCEPTABLE);

        }
        UserDto createdUser = authService.signupClient(signupRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/company/sign-up")
    public ResponseEntity<?> signupCompany(@RequestBody SignupRequestDTO signupRequestDTO){

        if (authService.presentByEmail(signupRequestDTO.getEmail())){
            return new ResponseEntity<>("This Email Has Already Used In Another Company! Please Try Another One. ", HttpStatus.NOT_ACCEPTABLE);

        }
        UserDto createdUser = authService.signupClient(signupRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

}

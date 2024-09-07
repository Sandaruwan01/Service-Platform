package com.service.ServicePlatform.dto;

import com.service.ServicePlatform.enums.UserRole;
import lombok.Data;

@Data
public class SignupRequestDTO {

    private Long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;



}

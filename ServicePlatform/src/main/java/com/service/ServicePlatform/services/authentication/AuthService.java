package com.service.ServicePlatform.services.authentication;

import com.service.ServicePlatform.dto.SignupRequestDTO;
import com.service.ServicePlatform.dto.UserDto;

public interface AuthService {

    UserDto signupClient(SignupRequestDTO signupRequestDTO);

    Boolean presentByEmail(String email);

    UserDto signupCompany(SignupRequestDTO signupRequestDTO);
}

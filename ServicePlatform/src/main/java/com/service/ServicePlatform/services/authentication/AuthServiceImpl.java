package com.service.ServicePlatform.services.authentication;

import com.service.ServicePlatform.dto.SignupRequestDTO;
import com.service.ServicePlatform.dto.UserDto;
import com.service.ServicePlatform.entity.User;
import com.service.ServicePlatform.enums.UserRole;
import com.service.ServicePlatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDTO signupRequestDTO){

        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }

    public Boolean presentByEmail(String email){

        return userRepository.findFirstByEmail(email) != null;
    }

    public UserDto signupCompany(SignupRequestDTO signupRequestDTO){

        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.COMPANY);

        return userRepository.save(user).getDto();
    }
}

package com.example.librarian.service;

import com.example.librarian.enums.UserRole;
import com.example.librarian.model.dto.UserDto;
import com.example.librarian.repository.UserRepository;
import com.example.librarian.repository.dao.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public RegistrationService(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;

    }

    public String userRegistration(UserDto userDto) {
        UserEntity existingUser = userService.findByEmail(userDto.getEmail());
        if (existingUser != null) {
            return "There is already an account registered with that email";
        } else {
            userDto.setUserRole(UserRole.USER);
            userService.saveUser(userDto);
            return "Registered";
        }
    }
}

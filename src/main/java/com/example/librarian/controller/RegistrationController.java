package com.example.librarian.controller;

import com.example.librarian.model.dto.UserDto;
import com.example.librarian.repository.UserRepository;
import com.example.librarian.service.RegistrationService;
import com.example.librarian.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    private UserService userService;
    private UserRepository userRepository;
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(UserService userService, UserRepository userRepository, RegistrationService registrationService){
        this.userService = userService;
        this.userRepository = userRepository;
        this.registrationService = registrationService;
    }

    @PostMapping(path = "/register")
    public String registration(@Valid @RequestBody UserDto userDto){
        return registrationService.userRegistration(userDto);
    }
}

package com.example.librarian.controller;

import com.example.librarian.model.dto.ReservationRequest;
import com.example.librarian.repository.dao.UserEntity;
import com.example.librarian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path ="/users/createReservation",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void createReservation(@RequestBody ReservationRequest request){
        userService.createReservation(request.getEmail(),request.getPhoneNumber());
    }
}

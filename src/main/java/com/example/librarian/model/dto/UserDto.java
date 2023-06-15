package com.example.librarian.model.dto;

import com.example.librarian.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @Email
    private String email;
    private String phoneNumber;
    @NotEmpty
    private String password;
    private UserRole userRole;
}

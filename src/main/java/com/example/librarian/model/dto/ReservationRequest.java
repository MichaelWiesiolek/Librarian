package com.example.librarian.model.dto;

import lombok.Data;

@Data
public class ReservationRequest {
    private String email;
    private String phoneNumber;
}

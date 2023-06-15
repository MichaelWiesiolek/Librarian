package com.example.librarian.service;

import com.example.librarian.repository.ReservationRepository;
import com.example.librarian.repository.dao.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation() {
    }

    public List<ReservationEntity> getAllReservations(){
        List<ReservationEntity> reservations = reservationRepository.findAll();
        return reservations;
    }
}

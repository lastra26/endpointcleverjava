package com.example.endpoint.services;

import com.example.endpoint.exceptions.BookingException;
import com.example.endpoint.jsons.CreateReservationRest;
import com.example.endpoint.jsons.ReservationRest;
import com.example.endpoint.jsons.RestaurantRest;

import java.util.List;

public interface ReservationService {

    ReservationRest getReservation(Long reservationId) throws BookingException;

    String createReservation (CreateReservationRest CreateReservationRest) throws BookingException;

    public List<ReservationRest> getReservation() throws BookingException;
}

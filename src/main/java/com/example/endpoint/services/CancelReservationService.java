package com.example.endpoint.services;

import com.example.endpoint.exceptions.BookingException;

public interface CancelReservationService {

    public String deleteReservation(String locator) throws BookingException;
}

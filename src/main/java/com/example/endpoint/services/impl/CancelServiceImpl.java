package com.example.endpoint.services.impl;

import com.example.endpoint.exceptions.BookingException;
import com.example.endpoint.exceptions.InternalServerErrorException;
import com.example.endpoint.exceptions.NotFoundException;
import com.example.endpoint.repositories.ReservationRepository;
import com.example.endpoint.services.CancelReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelServiceImpl implements CancelReservationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservationRepository reservationRepository;

    public String deleteReservation(String locator) throws BookingException {
        reservationRepository.findByLocator(locator)
                .orElseThrow(() -> new NotFoundException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));
        try {
            reservationRepository.deleteByLocator(locator);
        } catch (Exception e) {
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return "LOCATOR_DELETED";
    }
}

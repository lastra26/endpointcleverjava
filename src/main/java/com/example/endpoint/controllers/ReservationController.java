package com.example.endpoint.controllers;

import com.example.endpoint.exceptions.BookingException;
import com.example.endpoint.jsons.CreateReservationRest;
import com.example.endpoint.jsons.ReservationRest;
import com.example.endpoint.jsons.RestaurantRest;
import com.example.endpoint.responses.BookingResponse;
import com.example.endpoint.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest) throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK), "OK" , reservationService
                .createReservation(createReservationRest));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "consultaReservation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<ReservationRest>> getReservation() throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK", reservationService.getReservation());
    }




}

















package com.example.endpoint.controllers;

import com.example.endpoint.exceptions.BookingException;
import com.example.endpoint.responses.BookingResponse;
import com.example.endpoint.services.CancelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class CancelReservationController {

    @Autowired
    CancelReservationService cancelReservationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/deleteReservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> deleteReservation(@RequestParam String locator) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK"
                ,cancelReservationService.deleteReservation(locator));
    }


}





















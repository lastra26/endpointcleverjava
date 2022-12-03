package com.example.endpoint.controllers;

import com.example.endpoint.exceptions.BookingException;
import com.example.endpoint.jsons.RestaurantRest;
import com.example.endpoint.responses.BookingResponse;
import com.example.endpoint.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurant" + "/{" + "restaurantId" + "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurantById(restaurantId));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<RestaurantRest>> getRestaurant() throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurant());
    }


}

























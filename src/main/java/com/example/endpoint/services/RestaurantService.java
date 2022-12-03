package com.example.endpoint.services;

import com.example.endpoint.exceptions.BookingException;
import com.example.endpoint.jsons.RestaurantRest;

import java.util.List;

public interface RestaurantService {

    RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;

    public List<RestaurantRest> getRestaurant() throws BookingException;
}

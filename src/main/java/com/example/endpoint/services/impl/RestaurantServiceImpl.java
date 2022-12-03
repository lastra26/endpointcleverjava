package com.example.endpoint.services.impl;

import com.example.endpoint.entities.Restaurant;
import com.example.endpoint.exceptions.BookingException;
import com.example.endpoint.exceptions.NotFoundException;
import com.example.endpoint.jsons.RestaurantRest;
import com.example.endpoint.repositories.RestaurantRepository;
import com.example.endpoint.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
        return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
    }

    public List<RestaurantRest> getRestaurant() throws BookingException {
        final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
        return restaurantsEntity.stream().map(service -> modelMapper.map(service,RestaurantRest.class))
                .collect(Collectors.toList());
    }

    private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
        return restaurantRepository.findById(restaurantId).orElseThrow(() -> new NotFoundException("SNOT-404-1", "NOT_FOUND"));
    }
}

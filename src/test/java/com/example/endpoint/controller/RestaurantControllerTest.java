package com.example.endpoint.controller;

import com.example.endpoint.controllers.RestaurantController;
import com.example.endpoint.exceptions.BookingException;
import com.example.endpoint.services.RestaurantService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RestaurantControllerTest {


    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    RestaurantController restaurantController;

    @Before
    public void init() throws BookingException{
        MockitoAnnotations.initMocks(this);
    }
}





















































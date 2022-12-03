package com.example.endpoint.exceptions;

import com.example.endpoint.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class InternalServerErrorException extends BookingException {

    private static final long serialVersionUID= 1L;

    public InternalServerErrorException (String code, String message){
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }

    public InternalServerErrorException (String code, String message, ErrorDto data){
        super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }
}

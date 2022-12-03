package com.example.endpoint.exceptions;

import com.example.endpoint.dtos.ErrorDto;

import java.util.ArrayList;
import java.util.List;

// aqui faltan los seters ya que no se Enhabilita la creacion

public class BookingException extends Exception {

    private static final long serialVersionUID = 1L;

    private final List<ErrorDto> errorList  = new ArrayList<>();

    private final String code;

    private final int responseCode;

    public BookingException(String code, int responseCode, String message){
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public BookingException(String code, int responseCode, String message, List<ErrorDto> errorList){
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorList.addAll(errorList);
    }


    public List<ErrorDto> getErrorList() {
        return errorList;
    }

    public String getCode() {
        return code;
    }

    public int getResponseCode() {
        return responseCode;
    }


}

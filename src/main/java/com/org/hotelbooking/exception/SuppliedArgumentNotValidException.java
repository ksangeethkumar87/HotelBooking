/*
 * This is demo project for hotel booking manager
 */
package com.org.hotelbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author sangeeth
 */
@ResponseStatus(value = HttpStatus.OK)
public class SuppliedArgumentNotValidException extends RuntimeException
{

    private String message;

    public SuppliedArgumentNotValidException(String message)
    {
        super(message);
    }

}

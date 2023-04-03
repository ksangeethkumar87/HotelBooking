/*
 * This is demo project for hotel booking manager
 */
package com.org.hotelbooking.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author sangeeth
 */
@ControllerAdvice
public class GlobalExceptionHandler
{

    /**
     *
     * @param excpetion
     * @param webRequest
     * @return
     */
    @ExceptionHandler(RoomNotAvailableException.class)
    public ResponseEntity<ErrorDetails> handleRoomNotAvailableException(RoomNotAvailableException excpetion, WebRequest webRequest)
    {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), excpetion.getMessage(), webRequest.getDescription(false), "ROOM_NOT_AVAILABLE");

        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
    }

    /**
     *
     * @param excpetion
     * @param webRequest
     * @return
     */
    @ExceptionHandler(SuppliedArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleException(SuppliedArgumentNotValidException excpetion, WebRequest webRequest)
    {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), excpetion.getMessage(), webRequest.getDescription(false), "SUPPLIED_ARGUMENTS_NOT_VALID");

        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
    }
    
    /**
     *
     * @param excpetion
     * @param webRequest
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception excpetion, WebRequest webRequest)
    {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), excpetion.getMessage(), webRequest.getDescription(false), "INTERNAL_SERVER_ERROR");

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

/*
 * This is demo project for hotel booking manager
 */
package com.org.hotelbooking.exception;

import java.time.LocalDateTime;

/**
 *
 * @author sangeeth
 */
public class ErrorDetails
{

    private LocalDateTime dateTime;
    private String message;
    private String path;
    private String errorCode;

    public ErrorDetails()
    {
    }

    public ErrorDetails(LocalDateTime dateTime, String message, String path, String errorCode)
    {
        this.dateTime = dateTime;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime)
    {
        this.dateTime = dateTime;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

}

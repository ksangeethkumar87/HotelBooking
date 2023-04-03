/*
 * This is demo project for hotel booking manager
 */
package com.org.hotelbooking.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sangeeth
 */
@Entity
@Table
public class HotelBooking
{

    @Id
    @Column(nullable = false)
    private int bookingId;
    /**
     *
     */
    @Column(nullable = false)
    private String guestName;
    /**
     *
     */
    @Column(nullable = false)
    private String roomNumber;
    /**
     *
     */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date bookingDate;

    public int getBookingId()
    {
        return bookingId;
    }

    public void setBookingId(int bookingId)
    {
        this.bookingId = bookingId;
    }

    public String getGuestName()
    {
        return guestName;
    }

    public void setGuestName(String guestName)
    {
        this.guestName = guestName;
    }

    public String getRoomNumber()
    {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public Date getBookingDate()
    {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate)
    {
        this.bookingDate = bookingDate;
    }

}

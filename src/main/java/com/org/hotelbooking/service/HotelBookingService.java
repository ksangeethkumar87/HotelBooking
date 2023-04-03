/*
 * This is demo project for hotel booking manager
 */
package com.org.hotelbooking.service;

import com.org.hotelbooking.model.HotelBooking;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sangeeth
 */
public interface HotelBookingService
{

    /**
     * 
     * @param hotelBooking
     * @return 
     */
    HotelBooking createBooking(HotelBooking hotelBooking);

    /**
     * 
     * @param hotelBooking
     * @return 
     */
    boolean isRoomAvailable(HotelBooking hotelBooking);

    /**
     * 
     * @param guestName
     * @return 
     */
    List<HotelBooking> getAllBookingByGuest(String guestName);
    
    /**
     * 
     * @param bookingDate
     * @return 
     */
    long getAvailableRoomByDate(Date bookingDate);

//    /**
//     * 
//     * @return 
//     */
//    List<HotelBooking> getAllBooking();
}

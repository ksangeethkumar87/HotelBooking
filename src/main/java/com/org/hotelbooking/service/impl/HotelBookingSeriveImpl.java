/*
 * This is demo project for hotel booking manager
 */
package com.org.hotelbooking.service.impl;

import com.org.hotelbooking.model.HotelBooking;
import com.org.hotelbooking.repository.HotelBookingRepository;
import com.org.hotelbooking.service.HotelBookingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author sangeeth
 */
@Service
public class HotelBookingSeriveImpl implements HotelBookingService
{

    @Autowired
    private HotelBookingRepository hotelBookingRepository;

    @Value("${hotel.total.room.count}")
    private Integer totalRoomsCount;

    /**
     *
     * @param hotelBooking
     * @return
     */
    @Override
    public HotelBooking createBooking(HotelBooking hotelBooking)
    {
        return hotelBookingRepository.save(hotelBooking);
    }

    /**
     *
     * @param hotelBooking
     * @return
     */
    @Override
    public boolean isRoomAvailable(HotelBooking hotelBooking)
    {
        return hotelBookingRepository.isRoomAvailable(hotelBooking.getRoomNumber(), hotelBooking.getBookingDate());
    }

    /**
     *
     * @param guestName
     * @return
     */
    @Override
    public List<HotelBooking> getAllBookingByGuest(String guestName)
    {
        List<HotelBooking> hotelBookingList = new ArrayList<>();
        hotelBookingRepository.findAllByGuestName(guestName).forEach(hotelBooking -> hotelBookingList.add(hotelBooking));
        return hotelBookingList;
    }
    
    /**
     * 
     * @param bookingDate
     * @return 
     */
    @Override
    public long getAvailableRoomByDate(Date bookingDate)
    {
        long bookedRoomsCount = hotelBookingRepository.countByDate(bookingDate);
        
        return totalRoomsCount - bookedRoomsCount;
    }

//    /**
//     *
//     * @return
//     */
//    @Override
//    public List<HotelBooking> getAllBooking()
//    {
//        List<HotelBooking> hotelBookingList = new ArrayList<>();
//
//        hotelBookingRepository.findAll().forEach(hotelBooking -> hotelBookingList.add(hotelBooking));
//        return hotelBookingList;
//    }

}

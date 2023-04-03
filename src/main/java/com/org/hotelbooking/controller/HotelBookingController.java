/*
 * This is demo project for hotel booking manager
 */
package com.org.hotelbooking.controller;

import com.org.hotelbooking.exception.RoomNotAvailableException;
import com.org.hotelbooking.exception.SuppliedArgumentNotValidException;
import com.org.hotelbooking.model.HotelBooking;
import com.org.hotelbooking.service.HotelBookingService;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sangeeth
 */
@RestController
@RequestMapping("hotelbooking/api")
public class HotelBookingController
{

    @Autowired
    private HotelBookingService hotelBookingService;

    @PostMapping("/create")
    public ResponseEntity<HotelBooking> createBooking(@RequestBody HotelBooking hotelBooking)
    {
        if (Objects.isNull(hotelBooking) || Objects.isNull(hotelBooking.getGuestName())
                || hotelBooking.getGuestName().isEmpty() || Objects.isNull(hotelBooking.getBookingDate())
                || Objects.isNull(hotelBooking.getRoomNumber()) || hotelBooking.getRoomNumber().isEmpty())
        {
            throw new SuppliedArgumentNotValidException("Booking details not valid");
        }
        
        if(hotelBookingService.getAvailableRoomByDate(hotelBooking.getBookingDate()) < 1)
        {
             throw new RoomNotAvailableException("All Rooms Booked");
        }

        if (hotelBookingService.isRoomAvailable(hotelBooking))
        {
           HotelBooking savedHotelBooking =  hotelBookingService.createBooking(hotelBooking);
            return new ResponseEntity<>(savedHotelBooking, HttpStatus.CREATED);
        }
        else
        {
            throw new RoomNotAvailableException("Room not available");
        }
    }

    /**
     *
     * @param guestName
     * @return
     */
    @GetMapping("/userbookings")
    public ResponseEntity<List<HotelBooking>> getAllBookingByGuest(@RequestParam("guestName") String guestName)
    {
        List<HotelBooking> hotelBookingList = hotelBookingService.getAllBookingByGuest(guestName);
        
        return new ResponseEntity<>(hotelBookingList, HttpStatus.OK);
    }
    
     /**
     *
     * @param bookingDate
     * @return
     */
    @GetMapping("/availableroom")
    public ResponseEntity<?> getAvailableRoomByDate(@RequestParam("bookingDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date bookingDate)
    {
        long availableRoomsCount = hotelBookingService.getAvailableRoomByDate(bookingDate);

        return new ResponseEntity<>("Rooms Available: " + availableRoomsCount, HttpStatus.OK);
    }

//    /**
//     *
//     * @return
//     */
//    @GetMapping("/")
//    public List<HotelBooking> getAllBooking()
//    {
//        return hotelBookingService.getAllBooking();
//    }

}

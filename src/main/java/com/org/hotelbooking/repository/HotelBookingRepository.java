/*
 * This is demo project for hotel booking manager
 */
package com.org.hotelbooking.repository;

import com.org.hotelbooking.model.HotelBooking;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author sangeeth
 */
public interface HotelBookingRepository extends CrudRepository<HotelBooking, Integer>
{

    @Query(value = "select h from HotelBooking h where h.guestName =:guestName")
    List<HotelBooking> findAllByGuestName(@Param("guestName") String guestName);
    
    @Query(value = "select case when count(h) > 0 then false else true end from HotelBooking h where h.roomNumber =:roomNumber and h.bookingDate = :bookingDate")
    boolean isRoomAvailable(@Param("roomNumber") String roomNumber, @Param("bookingDate") Date bookingDate);
    
    @Query(value = "select count(h) from HotelBooking h where h.bookingDate =:bookingDate")
    long countByDate(@Param("bookingDate") Date bookingDate);
    
}

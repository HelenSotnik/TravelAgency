package com.softserve.repository;

import com.softserve.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

   @Query(value = "SELECT b FROM Booking b " +
           "WHERE b.hotel.id = :hotelId " +
           "AND b.checkInDate <= :dateToCheck " +
           "AND b.checkOutDate >= :dateToCheck")
   List<Booking> findBookingsByDateInRange(@Param("hotelId") long hotelId, @Param("dateToCheck") LocalDate dateToCheck);

   List<Booking> findBookingsByGuestEmail(String email);
   void deleteBookingById(long id);
}

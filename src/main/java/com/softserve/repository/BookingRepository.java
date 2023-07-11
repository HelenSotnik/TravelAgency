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

   @Query(value = "SELECT b FROM Booking b WHERE b.checkInDate <= :checkIn AND b.checkOutDate >= :checkOut")
   List<Booking> findByDateInRange(@Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut);
}

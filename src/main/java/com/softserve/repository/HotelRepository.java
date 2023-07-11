package com.softserve.repository;

import com.softserve.model.Hotel;
import com.softserve.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query(value = "SELECT hotel FROM Hotel hotel " +
            "WHERE hotel.name LIKE '%' || :keyword || '%' " +
            "OR hotel.description LIKE '%' || :keyword || '%' " +
            "OR hotel.location LIKE '%' || :keyword || '%'")
    List<Hotel> searchHotel(@Param("keyword")String keyword);
}

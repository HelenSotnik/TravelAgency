package com.softserve.service;

import com.softserve.exception.NullEntityReferenceException;
import com.softserve.model.Hotel;
import com.softserve.model.User;
import com.softserve.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    public Hotel create(Hotel hotel) {
            return hotelRepository.save(hotel);
    }

    public Hotel readById(long id) {
        return hotelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Hotel with id " + id + " not found"));
    }

    public Hotel update(Hotel hotel) {
        if (hotel != null) {
            readById(hotel.getId());
            return hotelRepository.save(hotel);
        }
        throw new NullEntityReferenceException("Hotel cannot be 'null'");
    }

    public void delete(long id) {
        hotelRepository.delete(readById(id));
    }

    public List<Hotel> getAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.isEmpty() ? new ArrayList<>() : hotels;
    }

    public List<Hotel> searchHotel(String keyword) {
        return hotelRepository.searchHotel(keyword);
    }
}

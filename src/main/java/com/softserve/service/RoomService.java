package com.softserve.service;

import com.softserve.model.Room;
import com.softserve.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room){
        return roomRepository.save(room);
    }

    public Room readById(long id) {
        Optional<Room> optional = roomRepository.findById(id);
        return optional.get();
    }

    public void delete(long id) {
        Room room = readById(id);
        roomRepository.delete(room);
    }

    public List<Room> getAll() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.isEmpty() ? new ArrayList<>() : rooms;
    }

    public List<Room> getByHotelId(long hotelId) {
        List<Room> tasks = roomRepository.findRoomsByHotel_Id(hotelId);
        return tasks.isEmpty() ? new ArrayList<>() : tasks;
    }

    public Room update(Room room) {
        Room oldRoom = readById(room.getId());
        return roomRepository.save(room);
    }

    public Room getHotelRoomById(long id) {
        return roomRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Room with id " + id + " not found"));
    }
}

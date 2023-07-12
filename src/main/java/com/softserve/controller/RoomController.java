package com.softserve.controller;

import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.service.HotelService;
import com.softserve.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private HotelService hotelService;

    @GetMapping("/{hotelId}/create")
    public String create(@PathVariable long hotelId, Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("hotelId", hotelId);
        return "create-room";
    }

    @PostMapping("/{hotelId}/create")
    public String create(@PathVariable long hotelId, @Validated @ModelAttribute("room") Room room,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "create-room";
        }
        Hotel hotel = hotelService.readById(hotelId);
        room.setHotel(hotel);
        roomService.createRoom(room);
        return "redirect:/rooms/{hotelId}";
    }

    @GetMapping("/{hotelId}/update/{roomId}")
    public String update(@PathVariable long hotelId, @PathVariable("roomId") long id, Model model) {
        Room room = roomService.readById(id);
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("room", room);
        return "edit-room";
    }

    @PostMapping("/{hotelId}/update/{roomId}")
    public String update(@PathVariable long hotelId, @PathVariable("roomId") long id, @ModelAttribute Room room) {
        room.setId(id);
        room.setHotel(hotelService.readById(hotelId));
        roomService.update(room);
        return "redirect:/rooms/{hotelId}";
    }

    @GetMapping("/{hotelId}/delete/{roomId}")
    public String delete(@PathVariable long hotelId,@PathVariable("roomId") long roomId, Model model) {
        roomService.delete(roomId);
        model.addAttribute("hotelId", hotelId);
        return "redirect:/rooms/{hotelId}";
    }

    @GetMapping("/{hotelId}")
    public String getAllRoomsByHotelId(@PathVariable long hotelId, Model model) {
        Hotel hotel = hotelService.readById(hotelId);
        model.addAttribute("hotel", hotel);
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("rooms", roomService.getByHotelId(hotelId));
        return "rooms-list";
    }
}

package com.example.demo.controller;

import com.example.demo.model.Hotel_Room;
import com.example.demo.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserPageController {

    private final HotelRoomService hotelRoomService;

    @Autowired
    public UserPageController(HotelRoomService hotelRoomService) {
        this.hotelRoomService = hotelRoomService;
    }

    @GetMapping("/user")
    public String findAll(Model model){
        List<Hotel_Room> hotelRoom = hotelRoomService.findAllHR();
        model.addAttribute("hotelRoom",hotelRoom);
        return "userPage";
    }

}

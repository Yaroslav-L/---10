package com.example.demo.service;

import com.example.demo.model.Hotel_Room;
import com.example.demo.repository.HotelRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelRoomService {

    private final HotelRoomRepo hotelRoomRepo;

    @Autowired
    public HotelRoomService(HotelRoomRepo hotelRoomRepo) {
        this.hotelRoomRepo = hotelRoomRepo;
    }

    public List<Hotel_Room> findAllHR(){ return hotelRoomRepo.findAll();}
}

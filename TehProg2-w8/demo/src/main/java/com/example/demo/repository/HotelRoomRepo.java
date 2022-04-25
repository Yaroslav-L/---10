package com.example.demo.repository;

import com.example.demo.model.Hotel_Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRoomRepo extends JpaRepository<Hotel_Room, Integer> {
}

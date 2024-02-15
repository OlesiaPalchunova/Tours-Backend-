package com.bd.tours.repository;

import com.bd.tours.entity.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    void saveMethod(){
        Hotel hotel = new Hotel();
        hotel.setCountRooms(30);
        hotel.setName("Stars");

        Hotel savedObject = hotelRepository.save(hotel);

        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

}
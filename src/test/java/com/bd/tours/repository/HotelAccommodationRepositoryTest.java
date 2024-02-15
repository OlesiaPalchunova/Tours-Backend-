package com.bd.tours.repository;

import com.bd.tours.entity.Hotel;
import com.bd.tours.entity.HotelAccommodation;
import com.bd.tours.entity.Tourist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelAccommodationRepositoryTest {

    @Autowired
    private HotelAccommodationRepository hotelAccRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TouristRepository touristRepository;

    @Test
    void saveMethod(){

        Hotel hotel = hotelRepository.findById(1L).orElse(null);
        Tourist tourist = touristRepository.findById(1L).orElse(null);
        List<HotelAccommodation> accs =  new ArrayList<>();
        HotelAccommodation acc1 = new HotelAccommodation();
        HotelAccommodation acc2 = new HotelAccommodation();
        HotelAccommodation acc3 = new HotelAccommodation();


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date;
        try {
            date = dateFormat.parse("14.02.2014");
            acc1.setHotel(hotel);
            acc1.setPrice(300);
            acc1.setDate(date);
            acc1.setNumber(234);
            acc1.setTourist(tourist);
            accs.add(acc1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date = dateFormat.parse("15.02.2014");
            acc2.setHotel(hotel);
            acc2.setPrice(300);
            acc2.setDate(date);
            acc2.setNumber(234);
            acc2.setTourist(tourist);
            accs.add(acc2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date = dateFormat.parse("176.02.2014");
            acc3.setHotel(hotel);
            acc3.setPrice(300);
            acc3.setDate(date);
            acc3.setNumber(234);
            acc3.setTourist(tourist);
            accs.add(acc3);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        hotelAccRepository.saveAll(accs);

    }

    @Test
    void findAllAccommodationsByTourist() {
        // Создаем туриста, чтобы использовать его в качестве аргумента для поиска
        Tourist tourist = new Tourist();
        tourist.setId(2L); // Предполагается, что у вашего туриста уже есть ID в базе данных

        // Вызываем метод поиска по туристу
        List<HotelAccommodation> accommodations = hotelAccRepository.findByTourist(tourist);

        // Проверяем, что список не пустой (что у туриста есть заселения)
        Assertions.assertFalse(accommodations.isEmpty());

        // Выводим результаты
        for (HotelAccommodation accommodation : accommodations) {
            System.out.println(accommodation);
        }
    }

    @Test
    void findAllAccommodationsByNumber() {
        int number = 234;

        List<HotelAccommodation> accommodations = hotelAccRepository.findByNumber(number);

        Assertions.assertFalse(accommodations.isEmpty());

        // Выводим результаты
        for (HotelAccommodation accommodation : accommodations) {
            System.out.println(accommodation);
        }
    }

}
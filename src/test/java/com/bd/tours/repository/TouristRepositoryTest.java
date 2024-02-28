package com.bd.tours.repository;

import com.bd.tours.entity.Tourist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TouristRepositoryTest {

    @Autowired
    private TouristRepository touristRepository;

    @Test
    void saveMethod(){
        Tourist tourist = new Tourist();
        tourist.setFirstName("Olesia");
        tourist.setSecondName("Palch");
        tourist.setAge(19);
        tourist.setGender("female");
        tourist.setLuggage(true);
        tourist.setCountChildren(0);

        Tourist savedObject = touristRepository.save(tourist);

        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod(){
//        touristRepository.save(new Tourist(6, ...))
        Long id = 6L;
        Tourist tourist = touristRepository.findById(id).get();

        tourist.setFirstName("Lesia");

        touristRepository.save(tourist);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;

        Tourist tourist = touristRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){
        Tourist tourist2 = new Tourist();
        tourist2.setFirstName("Tima");
        tourist2.setSecondName("Trubinov");
        tourist2.setAge(20);
        tourist2.setGender("male");
        tourist2.setLuggage(true);
        tourist2.setCountChildren(0);

        Tourist tourist3 = new Tourist();
        tourist3.setFirstName("Ann");
        tourist3.setSecondName("Fina");
        tourist3.setAge(35);
        tourist3.setGender("female");
        tourist3.setLuggage(false);
        tourist3.setCountChildren(2);

        touristRepository.saveAll(List.of(tourist2, tourist3));
    }

    @Test
    void findAllMethod(){
        List<Tourist> tourists = touristRepository.findAll();

        tourists.forEach((p) -> {
            System.out.println(p.getFirstName());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id = 3L;
        touristRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        Long id = 1L;
        Tourist tourist = touristRepository.findById(id).get();

        touristRepository.delete(tourist);
    }

    @Test
    void deleteAllMethod(){
        touristRepository.deleteAll();
    }

    @Test
    void countMethod(){
        long count = touristRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        Long id = 5L;
        boolean result = touristRepository.existsById(id);
        System.out.println(result);
    }
}
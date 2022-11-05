package org.binar.chapter4.repository;

import org.binar.chapter4.model.Seats;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

@SpringBootTest
public class SeatsRepositoryTest {
    @Autowired
    SeatsRepository seatsRepository;

    @Test
    void testInsertStudioName(){
        //buat object seats untuk data seats
        Seats seats = new Seats();
        seats.setStudioName("Studio A");


        //insert data ke table
        seatsRepository.save(seats);

        seats.setStudioName("Studio B");
        seatsRepository.save(seats);
        seats.setStudioName("Studio C");
        seatsRepository.save(seats);
    }
}

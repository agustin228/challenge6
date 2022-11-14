package org.binar.chapter4.repository;

import org.binar.chapter4.model.ChairNumber;
import org.binar.chapter4.model.Seats;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

@SpringBootTest
public class SeatsRepositoryTest {
    @Autowired
    SeatsRepository seatsRepository;
    //buat object seats untuk data seats
     Seats seats = new Seats();
     ChairNumber chairNumber = new ChairNumber();

    //    Test Case Menambahkan Nama Studio
    @Test
    void testInsertStudioNameToDb(String studioName, ChairNumber chairNumber) {



        seatsRepository.save(seats);

        //insert data ke table
        seats.setChairNumber(chairNumber);
        seatsRepository.save(seats);
        seats.setStudioName(studioName);
        seatsRepository.save(seats);
    }




}

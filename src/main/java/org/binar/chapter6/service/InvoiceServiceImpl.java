package org.binar.chapter6.service;

import lombok.extern.slf4j.Slf4j;
import org.binar.chapter6.model.Films;
import org.binar.chapter6.model.Schedules;
import org.binar.chapter6.model.Seats;
import org.binar.chapter6.model.UsersMovie;
import org.binar.chapter6.repository.FilmsRepository;
import org.binar.chapter6.repository.SchedulesRepository;
import org.binar.chapter6.repository.SeatsRepository;
import org.binar.chapter6.repository.UsersMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Slf4j
@Service
public class InvoiceServiceImpl implements  InvoiceService {

    @Autowired
    FilmsRepository filmRepo;

    @Autowired
    UsersMovieRepository userRepo;

    @Autowired
    SchedulesRepository schedRepo;

    @Autowired
    SeatsRepository seatRepo;


    @Override
    public Films getFilmName(String filmName) {
        return filmRepo.getFilmName(filmName).get(0);
    }

    @Override
    public Schedules getScheduleFilmByFilmName(String filmName) {
        return schedRepo.getFilmSchedule(filmName);
    }

    @Override
    public Seats getStudioSeats(Integer number, String studio) {
        return seatRepo.getChairNumber(number, studio);
    }

    @Override
    public UsersMovie getUser(String username) {
        try{
            UsersMovie consumer =  userRepo.getUsername(username);
            return consumer;
        }catch (Exception e){
            log.error("ERROR has been found! because : {}", e.getMessage());
            return null;
        }
    }
}

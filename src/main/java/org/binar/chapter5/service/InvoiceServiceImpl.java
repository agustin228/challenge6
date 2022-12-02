package org.binar.chapter5.service;

import org.binar.chapter5.model.Films;
import org.binar.chapter5.model.Schedules;
import org.binar.chapter5.model.Seats;
import org.binar.chapter5.model.UsersMovie;
import org.binar.chapter5.repository.FilmsRepository;
import org.binar.chapter5.repository.SchedulesRepository;
import org.binar.chapter5.repository.SeatsRepository;
import org.binar.chapter5.repository.UsersMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return userRepo.getUsername(username);

    }
}

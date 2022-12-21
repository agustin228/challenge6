package org.binar.chapter5.service;

import org.binar.chapter5.model.Films;
import org.binar.chapter5.model.Schedules;
import org.binar.chapter5.model.Seats;
import org.binar.chapter5.repository.FilmsRepository;
import org.binar.chapter5.repository.SchedulesRepository;
import org.binar.chapter5.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmsRepository filmsRepo;
    @Autowired
    SchedulesRepository schedRepo;


    Films films;

    //Service Menambahkan film baru
    @Override
    public void addNewFilm(String filmName, Boolean showing) {
        filmsRepo.insertFilmToDb(filmName, showing);
        filmsRepo.save(films);

    }

    //Service Mengupdate film
    @Override
    public void updateFilm(String filmName, Boolean showing, Integer filmCode) {
        filmsRepo.updateFilmToDb(filmName, showing, filmCode);
        filmsRepo.save(films);
    }

    //Service Menghapus film
    @Override
    public void deleteFilm(String filmName) {
        filmsRepo.deleteFilmFromDb(filmName);
        filmsRepo.save(films);
    }

    //Service Menampilkan film yang sedang tayang
    @Override
    public List<Films> showingFilm(Boolean showing) {
        List<Films> filmList = filmsRepo.findFilmByShowing(showing);
        return filmList;
    }

    //Service Menampilkan jadwal dari film tertentu
    @Override
    public List<Schedules> showingScheduleFilm(Integer filmCode) {
        List<Schedules> schedulesList = schedRepo.findScheduleByFilmCode(filmCode);
        return schedulesList;
    }




}

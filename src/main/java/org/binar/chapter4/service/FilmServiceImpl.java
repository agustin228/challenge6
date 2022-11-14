package org.binar.chapter4.service;

import org.binar.chapter4.model.Films;
import org.binar.chapter4.model.Schedules;
import org.binar.chapter4.repository.FilmsRepository;
import org.binar.chapter4.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmsRepository filmsrepo;
    SchedulesRepository schedRepo;

    @Override
    public void addNewFilm(String filmName, boolean showing) {


    }


    @Override
    public void updateFilm(Films films) {

    }

    @Override
    public void deleteFilm(Integer filmCode) {

    }

    @Override
    public List<Films> showingFilm(boolean showing) {
        List<Films> filmList = filmsrepo.findFilmByShowingNative(showing);
        return filmList;
    }

    @Override
    public List<Schedules> showingScheduleFilm(Integer filmCode) {
        List<Schedules> schedulesList = schedRepo.findScheduleByFilmCode(filmCode);
        return  schedulesList;
    }


}

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
    @Autowired
    SchedulesRepository schedRepo;


    Films films;

    //Service Menambahkan film baru
    @Override
    public void addNewFilm(String filmName, Boolean showing) {
        filmsrepo.insertFilmToDb(filmName, showing);
        filmsrepo.save(films);

    }

    //Service Mengupdate film
    @Override
    public void updateFilm(String filmName, Boolean showing, Integer filmCode) {
        filmsrepo.updateFilmToDb(filmName, showing, filmCode);
        filmsrepo.save(films);
    }

    //Service Menghapus film
    @Override
    public void deleteFilm(String filmName) {
        filmsrepo.deleteFilmFromDb(filmName);
        filmsrepo.save(films);
    }

    //Service Menampilkan film yang sedang tayang
    @Override
    public List<Films> showingFilm(Boolean showing) {
        List<Films> filmList = filmsrepo.findFilmByShowing(showing);
        return filmList;
    }

    //Service Menampilkan jadwal dari film tertentu
    @Override
    public List<Schedules> showingScheduleFilm(Integer filmCode) {
        List<Schedules> schedulesList = schedRepo.findScheduleByFilmCode(filmCode);
        return schedulesList;
    }


}

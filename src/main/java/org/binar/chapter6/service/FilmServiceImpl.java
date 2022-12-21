package org.binar.chapter6.service;

import lombok.extern.slf4j.Slf4j;
import org.binar.chapter6.model.Films;
import org.binar.chapter6.model.Schedules;
import org.binar.chapter6.repository.FilmsRepository;
import org.binar.chapter6.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
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

        try {
            filmsRepo.insertFilmToDb(filmName, showing);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
        }
    }

    //Service Mengupdate film
    @Override
    public void updateFilm(String filmName, Boolean showing, Integer filmCode) {
        try {
            filmsRepo.updateFilmToDb(filmName, showing, filmCode);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
        }
    }

    //Service Menghapus film
    @Override
    public void deleteFilm(String filmName) {
        try {
            filmsRepo.deleteFilmFromDb(filmName);
        }catch (Exception e){
            log.error("ERROR has been found because : {}", e.getMessage());
        }

    }

    //Service Menampilkan film yang sedang tayang
    @Override
    public List<Films> showingFilm(Boolean showing) {
        try{
            List<Films> filmList = filmsRepo.findFilmByShowing(showing);
            return filmList;
        }catch (Exception e){
            log.error("ERROR has been found! because : {}", e.getMessage());
            return null;
        }

    }

    //Service Menampilkan jadwal dari film tertentu
    @Override
    public List<Schedules> showingScheduleFilm(Integer filmCode) {
        try{
            List<Schedules> schedulesList = schedRepo.findScheduleByFilmCode(filmCode);
            return schedulesList;
        } catch (Exception e){
            log.error("ERROR has been found! because : {}", e.getMessage());
            return null;
        }
    }


}

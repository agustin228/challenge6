package org.binar.chapter5.service;

import org.binar.chapter5.model.Films;
import org.binar.chapter5.model.Schedules;
import org.binar.chapter5.model.Seats;


import java.util.List;

public interface FilmService {
    //Service menambahkan film baru
    void addNewFilm(String filmName, Boolean showing);


    //Service mengupdate nama film
    void updateFilm(String filmName, Boolean showing, Integer filmCode);

    //Service menghapus film
    void deleteFilm(String filmName);

    //Service menampilkan film yang sedang tayang
    List<Films> showingFilm(Boolean showing);

    //Service menampilkan jadwal dari film tertentu
    List<Schedules> showingScheduleFilm(Integer filmCode);






}

package org.binar.chapter4.service;

import org.binar.chapter4.model.Films;
import org.binar.chapter4.model.Schedules;


import java.util.List;

public interface FilmService {
    //Service menambahkan film baru
    void addNewFilm(String filmName, boolean showing );


    //Service mengupdate nama film
    void updateFilm(Films films);

    //Service menghapus film
    void deleteFilm(Integer filmCode);

    //Service menampilkan film yang sedang tayang
    List<Films> showingFilm(boolean showing);

    //Service menampilkan jadwal dari film tertentu
    List<Schedules> showingScheduleFilm(Integer filmCode);


}

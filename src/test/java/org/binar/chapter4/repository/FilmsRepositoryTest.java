package org.binar.chapter4.repository;


import org.binar.chapter4.model.Films;
import org.binar.chapter4.model.Schedules;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest

public class FilmsRepositoryTest {


    @Autowired
    FilmsRepository filmsRepo;


    @Autowired
    SchedulesRepository schedulesRepository;



    //    Test Case Menambahkan Film Baru
    @Test
    void testInsertNewFilmToDb() {
        filmsRepo.insertFilmToDb("filmName", true);

    }


    @Test
    void testFindFilmsByShowing() {
        List<Films> filmsList1 = filmsRepo.findFilmByShowing(true);
        filmsList1.forEach(film -> {
            System.out.println(film.getFilmName());
        });
    }

    //    Test Case Mengupdate Film
    @Test
    void testUpdateFilmToDb() {
        filmsRepo.updateFilmToDb("filmName", true, 01);

    }

    //    Test Case Menghapus Film Baru
    @Test
    void testDeleteFilmFromDb( ) {
        filmsRepo.deleteFilmFromDb("filmName");

    }

    @Test
    void testFindScheduleByFilm(){
        List<Schedules> schedules = schedulesRepository.findScheduleByFilmCode(02);
        schedules.forEach(sched -> {
            System.out.println(sched.getShowDate() + " " +  sched.getStartTime() + " " + sched.getEndTime());
        });

    }
}

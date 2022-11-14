package org.binar.chapter4.repository;

import org.binar.chapter4.model.Films;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FilmsRepositoryTest {


    @Autowired
    FilmsRepository filmsRepo;
    Films films = new Films();

    //    Test Case Menambahkan Film Baru
    @Test
    void testInsertNewFilmToDb(String filmName, boolean showing) {
        films.setFilmName(filmName);
        filmsRepo.save(films);

        films.setShowing(showing);
        filmsRepo.save(films);


    }

    @Test
    void main() {

        testUpdateFilmToDb("Astu", true, 1);
        testDeleteFilmFromDb("Astu");
    }

    @Test
    void testGetFilmsByShowing() {
        //Pake JPQL
        List<Films> filmsList = filmsRepo.findFilmsByShowing(true);
        filmsList.forEach(film -> {
            System.out.println(film.getFilmName());
        });

        //Pake @Query
        List<Films> filmsList2 = filmsRepo.findFilmByShowingNative(true);
        filmsList2.forEach(film -> {
            System.out.println(film.getFilmName());
        });

        //Pake @Query native query
        List<Films> filmsList1 = filmsRepo.findFilmByShowingNative(true);
        filmsList1.forEach(film -> {
            System.out.println(film.getFilmName());
        });
    }

    @Test
    void testUpdateFilmToDb(String filmName, boolean showing, Integer filmCode) {
        filmsRepo.updateFilmToDb(filmName, showing, filmCode);
        filmsRepo.save(films);

    }

    @Test
    void testDeleteFilmFromDb(String filmName) {
        filmsRepo.deleteFilmFromDb(filmName);
        filmsRepo.save(films);

    }

}

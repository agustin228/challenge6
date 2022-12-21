package org.binar.chapter5.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FilmServiceTest {

    @Autowired
    FilmServiceImpl impl;

    @Test
    void testAddNewFilmService(){
        impl.addNewFilm("Film", true);

    }

    @Test
    void testUpdateFilmService(){
        impl.updateFilm("Film", true, 1);
    }

    @Test
    void testDeleteFilmService(){
        impl.deleteFilm("Film");
    }
}

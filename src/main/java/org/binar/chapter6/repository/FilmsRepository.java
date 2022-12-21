package org.binar.chapter6.repository;


import org.binar.chapter6.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Repository //Identifier bean
public interface FilmsRepository extends JpaRepository<Films, Integer> {

    @Modifying
    @Query(value = "insert into films (film_name, showing) values (?1, ?2)", nativeQuery = true)
     void insertFilmToDb(String filmName, Boolean showing);



    //Service showingFilm
    @Query(value = "select film_name from films where showing = :showing", nativeQuery = true)
     List<Films> findFilmByShowing(@Param("showing")Boolean showing);

    //Service deleteFilm
    @Modifying
    @Query(value = "delete from films f where f.film_name = :filmName", nativeQuery = true)
     void deleteFilmFromDb(@Param("filmName")String filmName);

    //Service updateFilm
    @Modifying
    @Query(value = "update films set film_name = :filmName, showing = :showing where film_code = :filmCode", nativeQuery = true)
     void updateFilmToDb(@Param("filmName")String filmName, @Param("showing")Boolean showing, @Param("filmCode")Integer filmCode);


    @Query(value = "select * from films where film_name = :filmName", nativeQuery = true)
    List<Films> getFilmName(@Param("filmName")String filmName);










}

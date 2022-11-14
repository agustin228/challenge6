package org.binar.chapter4.repository;

import org.binar.chapter4.model.Films;
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
     void insertFilmToDb(String filmName, boolean showing);

    //JPQL format
     List<Films> findFilmsByShowing(boolean isShowing);

    //@Query format
    @Query(value = "SELECT f FROM Films f WHERE showing = :showing")
     List<Films> findFilmByShowingQuery(@Param("showing") boolean showing);

    //Service showingFilm
    @Query(value = "select film_name from films where showing = ?1", nativeQuery = true)
     List<Films> findFilmByShowingNative(boolean showing);

    //Service deleteFilm
    @Modifying
    @Query(value = "delete from films f where f.film_name = ?1", nativeQuery = true)
     void deleteFilmFromDb(String filmName);

    //Service updateFilm
    @Modifying
    @Query(value = "update films set film_name = ?1, showing = ?2 where film_code = ?3", nativeQuery = true)
     void updateFilmToDb(String filmName, boolean showing, Integer filmCode);

}

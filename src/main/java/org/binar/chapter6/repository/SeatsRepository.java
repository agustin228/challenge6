package org.binar.chapter6.repository;

import org.binar.chapter6.model.ChairNumber;
import org.binar.chapter6.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SeatsRepository extends JpaRepository<Seats, ChairNumber> {


    @Modifying
    @Query(value = "insert into seats (number, studio, studio_name) values  (:number, :studio, :studioName)", nativeQuery = true)
    void addChairNumber(@Param("number")Integer number,@Param("studio") String studio,@Param("studioName") String studioName);


    @Query(value = "select * from seats", nativeQuery = true)
    Seats getChairNumber(@Param("number")Integer number,@Param("studio") String studio);
}

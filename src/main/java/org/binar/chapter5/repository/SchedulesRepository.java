package org.binar.chapter5.repository;

import org.binar.chapter5.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {

    @Query(value = "select start_time, end_time, show_date where film_code=?1", nativeQuery = true)
    public List<Schedules> findScheduleByFilmCode(Integer filmCode);

    @Query(value = "select * from schedules sc inner join films f on f.film_code = sc.film_code where film_name = :filmName", nativeQuery = true)
    Schedules getFilmSchedule(@Param("filmName")String filmName);


}

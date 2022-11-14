package org.binar.chapter4.repository;

import org.binar.chapter4.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {

    @Query(value = "select start_time, end_time, show_date where film_code=?1", nativeQuery = true)
    public List<Schedules> findScheduleByFilmCode(Integer filmCode);



}

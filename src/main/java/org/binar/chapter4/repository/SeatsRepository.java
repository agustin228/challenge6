package org.binar.chapter4.repository;

import org.binar.chapter4.model.ChairNumber;
import org.binar.chapter4.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, ChairNumber> {
}

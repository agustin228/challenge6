package org.binar.chapter4.repository;

import org.binar.chapter4.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository <Films, String> {
}

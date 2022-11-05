package org.binar.chapter4.repository;

import org.binar.chapter4.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Identifier bean
public interface FilmsRepository extends JpaRepository <Films, String> {
}

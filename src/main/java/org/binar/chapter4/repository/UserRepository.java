package org.binar.chapter4.repository;

import org.binar.chapter4.model.UsersMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersMovie, String> {
}

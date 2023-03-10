package org.binar.chapter6.repository;

import org.binar.chapter6.model.Roles;
import org.binar.chapter6.model.enumerations.ERoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByName(ERoles name);
}

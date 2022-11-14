package org.binar.chapter4.repository;

import org.binar.chapter4.model.UsersMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UsersMovieRepository extends JpaRepository<UsersMovie, String> {

    //Service addNewFilm
    @Modifying
    @Query(value = "insert into users_movie (email, password, username) values (?1, ?2, ?3)", nativeQuery = true)
     void insertUserToDb(String email, String password, String username);

    //Service deleteUser
    @Modifying
    @Query(value = "delete from users_movie u where u.username = ?1", nativeQuery = true)
    void deleteUserFromDb(String username);

    //Service updateUser
    @Modifying
    @Query(value = "update users_movie set email = ?1, password = ?2 where username = ?3", nativeQuery = true)
    void updateUserToDb(String email, String password, String username);
}

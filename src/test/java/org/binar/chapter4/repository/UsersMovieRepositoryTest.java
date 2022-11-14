package org.binar.chapter4.repository;

import org.binar.chapter4.model.UsersMovie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersMovieRepositoryTest {
    @Autowired
    UsersMovieRepository userMovieRepo;
    UsersMovie usersMovie = new UsersMovie();

    @Test
        //    Test Case Menambahkan User
    void testInsertNewUserToDb(String email, String password, String username) {
        usersMovie.setEmail(email);
        userMovieRepo.save(usersMovie);

        usersMovie.setPassword(password);
        userMovieRepo.save(usersMovie);

        usersMovie.setUsername(username);
        userMovieRepo.save(usersMovie);
    }

    @Test
    void testUpdateUserToDb(String email, String password, String username) {
        userMovieRepo.updateUserToDb(email, password, username);
        userMovieRepo.save(usersMovie);
    }

    @Test
    void testDeleteUserFromDb(String username) {
        userMovieRepo.deleteUserFromDb(username);
        userMovieRepo.save(usersMovie);

    }

    @Test
    void main() {
        testInsertNewUserToDb("aa@mail.com", "asdfghj", "Mael");
        testUpdateUserToDb("aa@mail.com", "asdfghj", "Mael");
        testDeleteUserFromDb("aa");

    }

}

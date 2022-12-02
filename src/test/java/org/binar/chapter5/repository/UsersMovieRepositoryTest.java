package org.binar.chapter5.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersMovieRepositoryTest {
    @Autowired
    UsersMovieRepository userMovieRepo;


    @Test
        //    Test Case Menambahkan User
    void testInsertNewUserToDb() {
        userMovieRepo.insertUserToDb("email", "password", "username");

    }

    //    Test Case Mengupdate User
    @Test
    void testUpdateUserToDb() {
        userMovieRepo.updateUserToDb("email", "password", "username");

    }

    //    Test Case Menghapus User
    @Test
    void testDeleteUserFromDb() {
        userMovieRepo.deleteUserFromDb("username");


    }

//    @Test
//    void main() {
//        testInsertNewUserToDb("aa@mail.com", "asdfghj", "Mael");
//        testUpdateUserToDb("aa@mail.com", "asdfghj", "Mael");
//        testDeleteUserFromDb("aa");
//
//    }


}

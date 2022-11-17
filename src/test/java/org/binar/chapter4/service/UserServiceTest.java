package org.binar.chapter4.service;

import org.binar.chapter4.model.UsersMovie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    void testAddNewUserService(){
        userService.addNewUser("ok@mail.com", "rahasia", "admins");
    }

    @Test
    void testUpdateUserService(){
        userService.updateUser("an@mail.com", "12345678", "admins");
    }

    @Test
    void testDeleteUserService(){
        userService.deleteUser("admins");
    }



}

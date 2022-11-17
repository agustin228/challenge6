package org.binar.chapter4.controller;

import org.binar.chapter4.model.Films;
import org.binar.chapter4.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users_movie")
public class UserMovieController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/new_user")
    public ResponseEntity insertUser(@RequestParam("email") String email,
                                     @RequestParam("password") String password,
                                     @RequestParam("username") String username){
        Map<String, String> resp = new HashMap<>();

        try{
            userService.addNewUser(email, password, username);
            resp.put("message", "user baru dengan username " + username + " berhasil ditambahkan");
            return new ResponseEntity(resp, HttpStatus.OK);
    }
        catch (Exception e){
            resp.put("message", "user gagal ditambahkan karena " + e.getMessage());
            return new ResponseEntity(HttpStatus.OK);

        }
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestParam("emaik") String email,
                                     @RequestParam("password") String password,
                                     @RequestParam("username") String username){

        Map<String, String> resp = new HashMap<>();

        try{userService.updateUser(email, password, username);

            resp.put("message", "data user dengan username " + username + " berhasil diperbaharui");
            return new ResponseEntity(resp, HttpStatus.OK);
        }
        catch (Exception e){
            resp.put("message", "data user gagal diupdate dikarenakan " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }



    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam("username") String username){
       Map<String, String> resp = new HashMap<>();
        try{
            userService.deleteUser(username);
            resp.put("message", "data user dengan username" + username + " berhasil dihapus");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }catch (Exception e){
            resp.put("message", "data user gagal dihapus dikarenakan " + e.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

        }

    }




}

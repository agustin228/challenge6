package org.binar.chapter5.service;


import org.apache.catalina.User;
import org.binar.chapter5.model.UsersMovie;
import org.binar.chapter5.repository.UsersMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersMovieRepository userRepo;


    UsersMovie users;

    public UserServiceImpl(){

    }

    //Service Menambahkan user baru
    @Override
    public void addNewUser(String email, String password, String username) {
        userRepo.insertUserToDb(email, password, username);
        userRepo.save(users);
    }

    //Service Mengupdate user
    @Override
    public void updateUser(String email, String password, String username) {
        userRepo.updateUserToDb(email, password, username);
        userRepo.save(users);
    }

    //Service Menghapus user
    @Override
    public void deleteUser(String username) {
        userRepo.deleteUserFromDb(username);
        userRepo.save(users);

    }




}
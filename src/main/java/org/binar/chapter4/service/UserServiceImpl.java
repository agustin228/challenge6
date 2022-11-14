package org.binar.chapter4.service;


import org.binar.chapter4.repository.UsersMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersMovieRepository userRepo;

    @Override
    public void addNewUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}

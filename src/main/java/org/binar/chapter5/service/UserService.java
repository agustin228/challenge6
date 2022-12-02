package org.binar.chapter5.service;

import org.binar.chapter5.model.UsersMovie;

public interface UserService {
    //Service menambahkan user baru
    void addNewUser(String email, String password, String username);

    //Service mengupdate user
    void updateUser(String email, String password, String username);

    //Service menghapus user
    void deleteUser(String username);


}

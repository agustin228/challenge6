package org.binar.chapter6.service;

public interface UserService {
    //Service menambahkan user baru
    void addNewUser(String email, String password, String username);

    //Service mengupdate user
    void updateUser(String email, String password, String username);

    //Service menghapus user
    void deleteUser(String username);


}

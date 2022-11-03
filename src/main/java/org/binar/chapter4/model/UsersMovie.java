package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UsersMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}

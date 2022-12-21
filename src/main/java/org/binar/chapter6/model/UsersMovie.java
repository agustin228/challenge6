package org.binar.chapter6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class UsersMovie {


    @Id
    private String username;

    private String email;

    private String password;
}

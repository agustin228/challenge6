package org.binar.chapter6.model;

import lombok.Data;
import org.binar.chapter6.model.enumerations.ERoles;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERoles name;
}



package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer filmCode;


    private String filmName;


    private boolean showing;

}

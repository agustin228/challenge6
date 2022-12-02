package org.binar.chapter5.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Films {

    @Id
    private Integer filmCode;


    private String filmName;


    private Boolean showing;

}

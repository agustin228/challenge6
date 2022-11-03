package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String filmCode;

    @Column(name = "filmName")
    private String filmName;

    @Column(name = "isShowing")
    private boolean isShowing;

}

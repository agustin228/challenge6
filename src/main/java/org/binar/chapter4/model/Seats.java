package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Embeddable
public class Seats {
    @Id
    private String studioName;

    private Integer chairNumber;


}

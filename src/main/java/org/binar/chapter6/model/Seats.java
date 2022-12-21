package org.binar.chapter5.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity

public class Seats {
    @EmbeddedId
    private ChairNumber chairNumber;

    private String studioName;


}

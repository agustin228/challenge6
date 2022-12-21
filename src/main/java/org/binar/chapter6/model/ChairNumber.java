package org.binar.chapter6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

//Composite Key Field Chair Number
@Embeddable
@Getter
@Setter
public class ChairNumber implements Serializable {
//Composite key
    private String studio;
    private Integer number;






}

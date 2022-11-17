package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

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

package org.binar.chapter6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@Entity
public class Schedules {

    @Id
    private Integer scheduleId;

    //Relation ManyToOne with Films Entity Class (Bidirectional)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "filmCode")
    private Films filmCode;


    private LocalDate showDate;


    private LocalTime startTime;


    private LocalTime endTime;


    private Long price;


}

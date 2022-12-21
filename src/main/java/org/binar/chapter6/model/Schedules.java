package org.binar.chapter5.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


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

package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scheduleId;

    @ManyToOne
    private Films filmCode;

    @Column(name = "showDate")
    private Integer showDate;

    @Column(name = "startTime")
    private Integer startTime;

    @Column(name = "endTime")
    private Integer endTime;

    @Column(name = "price")
    private Integer price;


}

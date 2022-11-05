package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class Schedules {

    @Id
    private Integer scheduleId;

    @ManyToOne
    private Films filmCode;


    private Integer showDate;


    private Integer startTime;


    private Integer endTime;


    private Integer price;


}

package org.binar.chapter4.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Schedules {

    @Id
    private Integer scheduleId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Films filmCode;


    private Date showDate;


    private Date startTime;


    private Date endTime;


    private Long price;


}

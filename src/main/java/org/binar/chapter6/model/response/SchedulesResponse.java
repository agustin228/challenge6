package org.binar.chapter6.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulesResponse {
    @JsonFormat(pattern = "dd:MM:yy")
    private LocalDate showDate;

    @JsonFormat(pattern = "hh:mm:ss")
    private LocalTime startTime;

    @JsonFormat(pattern = "hh:mm:ss")
    private LocalTime endTime;
}

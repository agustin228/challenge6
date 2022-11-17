package org.binar.chapter4.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulesResponse {
    @JsonFormat(pattern = "dd:MM:yy")
    private LocalDate showDate;

    @JsonFormat(pattern = "hh:mm:ss")
    private LocalDate startTime;

    @JsonFormat(pattern = "hh:mm:ss")
    private LocalDate endTime;
}

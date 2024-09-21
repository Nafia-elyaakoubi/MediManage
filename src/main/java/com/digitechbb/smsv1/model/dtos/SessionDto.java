package com.digitechbb.smsv1.model.dtos;


import java.time.LocalDate;
import java.time.LocalTime;

public record SessionDto(
        LocalDate sessionDay,
        LocalTime startTime,
        LocalTime endTime,
        Long subjectId
) {
}

package com.digitechbb.smsv1.model.dtos;



public record AbsenceDto(
        String absenceNumber,
        String reason,
        Long sessionId,
        Long studentId

) {
}

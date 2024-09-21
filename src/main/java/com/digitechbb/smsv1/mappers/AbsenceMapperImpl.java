package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.AbsenceDto;
import com.digitechbb.smsv1.model.entities.Absence;
import com.digitechbb.smsv1.model.entities.Student;
import com.digitechbb.smsv1.model.entities.Session;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapperImpl implements AbsenceMapper {
    @Override
    public Absence toEntity(AbsenceDto absenceDto) {
        Absence absence = new Absence();
        absence.setAbsenceNumber(absenceDto.absenceNumber());
        absence.setReason(absenceDto.reason());
        absence.setSession(absenceDtoToSession(absenceDto));
        absence.setStudent(absenceDtoToStudent(absenceDto));


        return absence;
    }


    @Override
    public AbsenceDto toDto(Absence absence) {
        Long studentId = absenceToStudentId(absence);
        Long sessionId = absenceToSessionId(absence);

        return new AbsenceDto(
                absence.getAbsenceNumber(),
                absence.getReason(),
                sessionId,
                studentId
        );
    }

    private Long absenceToSessionId(Absence absence) {
        if (absence == null) return null;
        Session session = absence.getSession();
        if (session == null) return null;
        Long sessionId = session.getId();
        if (session == null) return null;
        return sessionId;
    }

    private Long absenceToStudentId(Absence absence) {
        if (absence == null) return null;
        Student student = absence.getStudent();
        if (student == null) return null;
        Long studentId = student.getId();
        if (studentId == null) return null;
        return studentId;
    }

    protected Student absenceDtoToStudent(AbsenceDto absenceDto) {
        if (absenceDto == null) {
            return null;
        }

        Student student = new Student();

        student.setId(absenceDto.studentId());

        return student;
    }

    protected Session absenceDtoToSession(AbsenceDto absenceDto) {
        if (absenceDto == null) {
            return null;
        }

        Session session = new Session();

        session.setId(absenceDto.sessionId());

        return session;
    }


}

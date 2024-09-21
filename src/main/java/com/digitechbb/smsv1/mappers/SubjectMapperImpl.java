package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.SubjectDto;
import com.digitechbb.smsv1.model.entities.ScholarLevel;
import com.digitechbb.smsv1.model.entities.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapperImpl implements SubjectMapper {
    @Override
    public Subject toEntity(SubjectDto subjectDto) {
        if (subjectDto == null) return null;
        Subject subject = new Subject();
        subject.setReference(subjectDto.reference());
        subject.setName(subjectDto.name());
        subject.setScholarLevel(subjectDtoToScholarLevel(subjectDto));
        return subject;
    }

    private ScholarLevel subjectDtoToScholarLevel(SubjectDto subjectDto) {
        if (subjectDto == null) return null;
        ScholarLevel shScholarLevel = new ScholarLevel();
        shScholarLevel.setId(subjectDto.scholarLevel());
        return shScholarLevel;
    }

    @Override
    public SubjectDto toDto(Subject subject) {
        Long scholarLevelId = subjectToScholarLevelId(subject);
        if (subject == null) return null;
        return new SubjectDto(
                subject.getReference(),
                subject.getName(),
                scholarLevelId
        );
    }

    private Long subjectToScholarLevelId(Subject subject) {
        if (subject==null) return null;
        ScholarLevel scholarLevel = subject.getScholarLevel();
        if (scholarLevel==null) return  null;
        Long scholarLevelId = scholarLevel.getId();
        if (scholarLevelId==null) return null;
        return scholarLevelId;
    }
}

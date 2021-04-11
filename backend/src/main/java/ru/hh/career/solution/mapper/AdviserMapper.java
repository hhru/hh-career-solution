package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Singleton;
import java.time.LocalDateTime;

@Singleton
public class AdviserMapper {

    public Adviser map(AdviserDto adviserDto) {
        return adviserDto == null ? null : new Adviser(
                adviserDto.getAdviserId(),
                adviserDto.getName(),
                adviserDto.getSoname(),
                LocalDateTime.now(),
                LocalDateTime.now());
    }

    public AdviserDto map(Adviser adviser) {
        return adviser == null ? null : new AdviserDto(
                adviser.getId(),
                adviser.getName(),
                adviser.getSurname(),
                adviser.getCreated().toString(),
                adviser.getUpdated().toString());
    }
}

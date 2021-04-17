package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Singleton;
import java.time.LocalDateTime;

@Singleton
public class AdviserMapper {

  private final AreaMapper areaMapper;

  public AdviserMapper(AreaMapper areaMapper) {
    this.areaMapper = areaMapper;
  }

  public Adviser map(AdviserDto adviserDto) {
    return adviserDto == null ? null : new Adviser(
      adviserDto.getAdviserId(),
      adviserDto.getName(),
      adviserDto.getSurname(),
      adviserDto.getConsultation(),
      adviserDto.getExperience(),
      adviserDto.getCareerPractice(),
      adviserDto.getCustomerType(),
      adviserDto.getProblemType(),
      LocalDateTime.now(),
      LocalDateTime.now());
  }

  public AdviserDto map(Adviser adviser) {
    return adviser == null ? null : new AdviserDto(
      adviser.getId(),
      adviser.getName(),
      adviser.getSurname(),
      adviser.getConsultation(),
      adviser.getExperience(),
      adviser.getCareerPractice(),
      adviser.getCustomerType(),
      adviser.getProblemType(),
      adviser.getCreated(),
      adviser.getUpdated(),
      areaMapper.map(adviser.getArea()),
      adviser.getEducationalList());
  }

}

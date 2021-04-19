package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.EducationalInstitutionDto;
import ru.hh.career.solution.entity.AdviserToEducational;

import javax.inject.Singleton;

@Singleton
public class EducationalInstitutionMapper {

  private final EducationalPeriodMapper educationalPeriodMapper;

  public EducationalInstitutionMapper(EducationalPeriodMapper educationalPeriodMapper) {
    this.educationalPeriodMapper = educationalPeriodMapper;
  }

  public EducationalInstitutionDto map(AdviserToEducational adviser) {
    return adviser == null ? null : new EducationalInstitutionDto(
      adviser.getEducationalInstitution().getId(),
      adviser.getEducationalInstitution().getCountryIsoCode(),
      adviser.getEducationalInstitution().getName(),
      adviser.getEducationalInstitution().getSite(),
      educationalPeriodMapper.map(adviser.getEducationalPeriod())
      );
  }
}

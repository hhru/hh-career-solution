package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.EducationalInstitutionDto;
import ru.hh.career.solution.entity.EducationalInstitution;

public final class EducationalInstitutionMapper {

  public static EducationalInstitutionDto map(EducationalInstitution educationalInstitution) {
    return educationalInstitution == null ? null : new EducationalInstitutionDto(
      educationalInstitution.getId(),
      educationalInstitution.getCountryIsoCode(),
      educationalInstitution.getName(),
      educationalInstitution.getSite());
  }

}

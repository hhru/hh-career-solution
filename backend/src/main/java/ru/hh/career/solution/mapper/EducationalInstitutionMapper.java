package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.EducationalInstitutionDto;
import ru.hh.career.solution.entity.EducationalInstitution;

import java.time.LocalDateTime;

public final class EducationalInstitutionMapper {

  public static EducationalInstitution map(EducationalInstitutionDto educational) {
    return educational == null ? null : new EducationalInstitution(
      educational.getId(),
      educational.getCountryIsoCode(),
      educational.getName(),
      educational.getSite(),
      LocalDateTime.now(),
      LocalDateTime.now());
  }

}

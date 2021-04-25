package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.EducationalPeriodDto;
import ru.hh.career.solution.entity.EducationalPeriod;

public final class EducationalPeriodMapper {

  public static EducationalPeriodDto map(EducationalPeriod period) {
    return period == null ? null : new EducationalPeriodDto(
      period.getId(),
      period.getYearFrom(),
      period.getYearTo());
  }

  public static EducationalPeriod map(EducationalPeriodDto period) {
    return period == null ? null : new EducationalPeriod(
      period.getId(),
      period.getYearFrom(),
      period.getYearTo());
  }

}

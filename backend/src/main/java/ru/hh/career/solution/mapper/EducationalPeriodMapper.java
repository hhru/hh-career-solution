package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.EducationalPeriodDto;
import ru.hh.career.solution.entity.EducationalPeriod;

import javax.inject.Singleton;

@Singleton
public class EducationalPeriodMapper {

  public EducationalPeriodDto map(EducationalPeriod period) {
    return period == null ? null : new EducationalPeriodDto(
      period.getId(),
      period.getYearFrom(),
      period.getYearTo()
    );
  }
}

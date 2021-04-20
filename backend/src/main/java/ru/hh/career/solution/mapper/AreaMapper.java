package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AreaDto;
import ru.hh.career.solution.entity.Area;

public final class AreaMapper {

  public static AreaDto map(Area area) {
    return area == null ? null : new AreaDto(
      area.getId(),
      area.getCountryIsoCode(),
      area.getName());
  }

}

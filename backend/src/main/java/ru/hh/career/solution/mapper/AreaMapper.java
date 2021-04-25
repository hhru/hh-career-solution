package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AreaDto;
import ru.hh.career.solution.entity.Area;

import java.time.LocalDateTime;

public final class AreaMapper {

  public static AreaDto map(Area area) {
    return area == null ? null : new AreaDto(
      area.getId(),
      area.getCountryIsoCode(),
      area.getName());
  }

  public static Area map(AreaDto area) {
    return area == null ? null : new Area(
      area.getId(),
      area.getCountryIsoCode(),
      area.getName(),
      LocalDateTime.now(),
      LocalDateTime.now());
  }

}

package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AreaDto;
import ru.hh.career.solution.entity.Area;

import javax.inject.Singleton;

@Singleton
public class AreaMapper {

  public AreaDto map(Area area) {
    return area == null ? null : new AreaDto(
      area.getId(),
      area.getCountryIsoCode(),
      area.getName(),
      area.getCreated(),
      area.getUpdated()
    );
  }
}

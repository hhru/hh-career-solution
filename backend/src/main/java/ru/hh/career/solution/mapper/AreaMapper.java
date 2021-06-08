package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AreaDto;
import ru.hh.career.solution.entity.Area;

public class AreaMapper {

  public static Area mapToArea(AreaDto areaDto) {
    return areaDto == null ? null : new Area(
      areaDto.getId(),
      areaDto.getName(),
      areaDto.getParentId());
  }

  public static AreaDto mapToAreaDto(Area area) {
    return area == null ? null : new AreaDto(
      area.getId(),
      area.getName(),
      area.getParentId());
  }
}

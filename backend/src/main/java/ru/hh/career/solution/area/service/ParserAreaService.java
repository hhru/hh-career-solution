package ru.hh.career.solution.area.service;

import org.springframework.stereotype.Service;
import ru.hh.career.solution.area.dto.AreaDto;
import ru.hh.career.solution.area.dto.AreaParser;
import ru.hh.career.solution.area.entity.Area;
import ru.hh.career.solution.dao.CheckerOnNullDao;
import ru.hh.career.solution.dao.GenericDao;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ParserAreaService {
  private final GenericDao genericDao;
  private final CheckerOnNullDao checkerOnNullDao;
  private final AreaParser areaParser;

  @Inject
  public ParserAreaService(GenericDao genericDao, CheckerOnNullDao checkerOnNullDao, AreaParser areaParser) {
    this.genericDao = genericDao;
    this.checkerOnNullDao = checkerOnNullDao;
    this.areaParser = areaParser;
  }

  public List<AreaDto> parseSubArea(List<AreaDto> areaDtos) {
    List<AreaDto> areas = new ArrayList<>(areaDtos);
    for (AreaDto areaDto : areaDtos) {
      if (areaDto.getAreaDtos().isEmpty()) {
        return areaDtos;
      }
      areas.addAll(parseSubArea(areaDto.getAreaDtos()));
    }
    return areas;
  }

//  public List<AreaDto> parseSubArea(List<AreaDto> areaDtos) {
//    List<AreaDto> areas = new ArrayList<AreaDto>();
//    for (AreaDto areaDto : areaDtos) {
//      areas.add(new AreaDto(areaDto.getId(), areaDto.getName(), areaDto.getParentId()));
//      if (areaDto.getAreaDtos().size() == 0) {
//        return areas;
//      }
//      areas.addAll(parseSubArea(areaDto.getAreaDtos()));
//    }
//    return areas;
//  }


  @Transactional
  public void parseArea() throws ExecutionException, InterruptedException {
    if (checkerOnNullDao.isAreaPresent()) {
      return;
    }
    List<AreaDto> areaDtos = Arrays.asList(areaParser.parse());
    areaDtos = parseSubArea(areaDtos);
    for (AreaDto areaDto : areaDtos) {
      Area area = new Area(
              areaDto.getId(),
              areaDto.getName(),
              areaDto.getParentId()
      );
      genericDao.save(area);
    }
  }
}

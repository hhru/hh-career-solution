package ru.hh.career.solution.area.service;

import org.springframework.stereotype.Service;
import ru.hh.career.solution.area.dto.AreaDto;
import ru.hh.career.solution.area.dto.AreaParser;
import ru.hh.career.solution.area.entity.Area;
import ru.hh.career.solution.dao.CheckerOnNullDao;
import ru.hh.career.solution.dao.GenericDao;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

  public Set<AreaDto> parseSubArea(List<AreaDto> areaDtos) {
    Set<AreaDto> areas = new HashSet<>(areaDtos) {};
    for (AreaDto areaDto : areaDtos) {
      areas.addAll(parseSubArea(areaDto.getAreaDtos()));
    }
    return areas;
  }

  @Transactional
  public void parseArea() throws ExecutionException, InterruptedException {
    if (checkerOnNullDao.isAreaPresent()) {
      return;
    }
    List<AreaDto> areaDtos = Arrays.asList(areaParser.parse());
    Set<AreaDto> areaDtosSet = parseSubArea(areaDtos);
    areaDtosSet.forEach(area -> genericDao.save((new Area(
            area.getId(),
            area.getName(),
            area.getParentId()
    ))));
  }
}

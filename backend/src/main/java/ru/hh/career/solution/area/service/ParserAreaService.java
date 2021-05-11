package ru.hh.career.solution.area.service;

import org.springframework.stereotype.Service;
import ru.hh.career.solution.area.dao.CheckerOnNullDao;
import ru.hh.career.solution.area.dto.AreaDto;
import ru.hh.career.solution.area.dto.AreaParser;
import ru.hh.career.solution.area.entity.Area;
import ru.hh.career.solution.dao.GenericDao;

import javax.inject.Inject;
import javax.transaction.Transactional;
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

  @Transactional
  public void parseArea() throws ExecutionException, InterruptedException {
    if (checkerOnNullDao.isAreaPresent()) {
      return;
    }
    AreaDto[] areaDtos = areaParser.parse();
    for (AreaDto areaDto : areaDtos) {
      Area area = new Area(
              areaDto.getId(),
              areaDto.getName(),
              areaDto.getParentId()
      );
      genericDao.saveOrUpdate(area);
    }
  }
}

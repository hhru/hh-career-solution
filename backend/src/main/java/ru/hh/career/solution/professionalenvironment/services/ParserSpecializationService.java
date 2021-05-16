package ru.hh.career.solution.professionalenvironment.services;


import org.springframework.stereotype.Service;
import ru.hh.career.solution.dao.GenericDao;
import ru.hh.career.solution.professionalenvironment.dao.CheckerOnNullDao;
import ru.hh.career.solution.professionalenvironment.dto.ProfessionalEnvironmentDto;
import ru.hh.career.solution.professionalenvironment.dto.ProfessionalEnvironmentParser;
import ru.hh.career.solution.professionalenvironment.entity.ProfessionalEnvironment;
import ru.hh.career.solution.professionalenvironment.entity.Specialization;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ParserSpecializationService {
  private final GenericDao genericDao;
  private final CheckerOnNullDao checkerOnNullDao;
  private final ProfessionalEnvironmentParser professionalEnvironmentParser;

  @Inject
  public ParserSpecializationService(GenericDao genericDao, CheckerOnNullDao checkerOnNullDao,
                                     ProfessionalEnvironmentParser professionalEnvironmentParser) {
    this.genericDao = genericDao;
    this.checkerOnNullDao = checkerOnNullDao;
    this.professionalEnvironmentParser = professionalEnvironmentParser;
  }

  @Transactional
  public void parseSpecialization() throws IOException, ExecutionException, InterruptedException {
    if (checkerOnNullDao.isSpecialisationsPresent()) {
      return;
    }
    ProfessionalEnvironmentDto[] professionalEnvironmentDtos = professionalEnvironmentParser.parse();
    for (ProfessionalEnvironmentDto professionalEnvironmentDto : professionalEnvironmentDtos) {
      ProfessionalEnvironment professionalEnvironment = new ProfessionalEnvironment(
              professionalEnvironmentDto.getId(),
              professionalEnvironmentDto.getName()
      );
      professionalEnvironment.setSpecializationSet(professionalEnvironmentDto.getSpecializations().stream().map(s -> new Specialization(
              s.getSpecializationId(),
              s.getName(),
              s.getLaboring(),
              professionalEnvironment
      )).collect(Collectors.toSet()));
      genericDao.save(professionalEnvironment);
    }
  }
}

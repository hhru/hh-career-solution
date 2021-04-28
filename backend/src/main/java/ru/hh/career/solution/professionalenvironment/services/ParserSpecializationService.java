package ru.hh.career.solution.professionalenvironment.services;


import ru.hh.career.solution.professionalenvironment.dao.CheckerOnNullDAO;
import ru.hh.career.solution.professionalenvironment.dao.GenericDao;
import ru.hh.career.solution.professionalenvironment.dto.ParserProfessionalEnvironmentAndSpecialization;
import ru.hh.career.solution.professionalenvironment.dto.ProfessionalEnvironmentDto;
import ru.hh.career.solution.professionalenvironment.dto.SpecializationDto;
import ru.hh.career.solution.professionalenvironment.entity.ProfessionalEnvironment;
import ru.hh.career.solution.professionalenvironment.entity.Specialization;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ParserSpecializationService {
  private final GenericDao genericDao;
  private final CheckerOnNullDAO checkerOnNullDAO;

  @Inject
  public ParserSpecializationService(GenericDao genericDao, CheckerOnNullDAO checkerOnNullDAO) {
    this.genericDao = genericDao;
    this.checkerOnNullDAO = checkerOnNullDAO;
  }

  @Transactional
  public boolean checkBdOnNull() {
    return this.checkerOnNullDAO.checkOnNullDAO();
  }

  @Transactional
  public void mainParser() throws IOException, ExecutionException, InterruptedException {
    if (checkBdOnNull()) {
      return;
    }
    ParserProfessionalEnvironmentAndSpecialization parserProfessionalEnvironmentAndSpecialization =
            new ParserProfessionalEnvironmentAndSpecialization();
    ProfessionalEnvironmentDto[] professionalEnvironmentDtos = parserProfessionalEnvironmentAndSpecialization.parse();
    for (ProfessionalEnvironmentDto professionalEnvironmentDto : professionalEnvironmentDtos) {
      ProfessionalEnvironment professionalEnvironment = new ProfessionalEnvironment(
              professionalEnvironmentDto.getId(),
              professionalEnvironmentDto.getName()
      );
      professionalEnvironment.setSpecializationSet(professionalEnvironmentDto.getSpecializations().stream().map(s -> new Specialization(
              s.getIdSpecialization(),
              s.getName(),
              s.getLaboring(),
              professionalEnvironment
      )).collect(Collectors.toSet()));
      genericDao.save(professionalEnvironment);
    }
  }
}

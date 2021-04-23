package ru.hh.career.solution.professionalenvironmentandspecialization.services;

import ru.hh.career.solution.professionalenvironmentandspecialization.dao.GenericDao;
import ru.hh.career.solution.professionalenvironmentandspecialization.dto.ParserProfessionalEnvironmentAndSpecialization;
import ru.hh.career.solution.professionalenvironmentandspecialization.dto.ProfessionalEnvironmentDto;
import ru.hh.career.solution.professionalenvironmentandspecialization.dto.SpecializationDto;
import ru.hh.career.solution.professionalenvironmentandspecialization.entity.ProfessionalEnvironmentEntity;
import ru.hh.career.solution.professionalenvironmentandspecialization.entity.SpecializationEntity;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Singleton
public class ParserService {
  private final GenericDao genericDao;

  @Inject
  public ParserService(GenericDao genericDao) {
    this.genericDao = genericDao;
  }

  @Transactional
  public void mainParser() throws IOException, ExecutionException, InterruptedException {
    ParserProfessionalEnvironmentAndSpecialization parserProfessionalEnvironmentAndSpecialization =
            new ParserProfessionalEnvironmentAndSpecialization();
    ProfessionalEnvironmentDto[] professionalEnvironmentDtos = parserProfessionalEnvironmentAndSpecialization.parse();
    for (ProfessionalEnvironmentDto professionalEnvironmentDto : professionalEnvironmentDtos) {
      ProfessionalEnvironmentEntity professionalEnvironmentEntity = new ProfessionalEnvironmentEntity(
              professionalEnvironmentDto.getId(),
              professionalEnvironmentDto.getName()
      );
      genericDao.save(professionalEnvironmentEntity);
      for (SpecializationDto specializationDto : professionalEnvironmentDto.getSpecializations()){
        SpecializationEntity specializationEntity =
                new SpecializationEntity(
                        specializationDto.getIdSpecialization(),
                        specializationDto.getName(),
                        specializationDto.getLaboring(),
                        professionalEnvironmentDto.getId()
                );
        genericDao.save(specializationEntity);
      }
    }
  }
}

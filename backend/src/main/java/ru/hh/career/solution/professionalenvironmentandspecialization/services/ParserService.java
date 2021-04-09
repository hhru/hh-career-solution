package ru.hh.career.solution.professionalenvironmentandspecialization.services;

import ru.hh.career.solution.professionalenvironmentandspecialization.dao.ProfessionalEnvironmentDao;
import ru.hh.career.solution.professionalenvironmentandspecialization.dao.SpecializationDao;
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
  private final ProfessionalEnvironmentDao professionalEnvironmentDao;
  private final SpecializationDao specializationDao;

  @Inject
  public ParserService(ProfessionalEnvironmentDao professionalEnvironmentDao, SpecializationDao specializationDao) {
    this.professionalEnvironmentDao = professionalEnvironmentDao;
    this.specializationDao = specializationDao;
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
      professionalEnvironmentDao.save(professionalEnvironmentEntity);
      for (SpecializationDto specializationDto : professionalEnvironmentDto.getSpecializations()){
        SpecializationEntity specializationEntity =
                new SpecializationEntity(
                        specializationDto.getIdSpecialization(),
                        specializationDto.getName(),
                        specializationDto.getLaboring(),
                        professionalEnvironmentDto.getId()
                );
        specializationDao.save(specializationEntity);
      }
    }
  }
}

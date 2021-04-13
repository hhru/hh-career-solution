package ru.hh.career.solution.professionalenvironmentandspecialization.services;

import ru.hh.career.solution.professionalenvironmentandspecialization.dao.ProfessionalEnvironmentDao;
import ru.hh.career.solution.professionalenvironmentandspecialization.dao.SpecializationDao;
import ru.hh.career.solution.professionalenvironmentandspecialization.dto.ParserProfessionalEnvironmentAndSpecialization;
import ru.hh.career.solution.professionalenvironmentandspecialization.dto.ProfessionalEnvironmentDto;
import ru.hh.career.solution.professionalenvironmentandspecialization.dto.SpecializationsDto;
import ru.hh.career.solution.professionalenvironmentandspecialization.entity.ProfessionalEnvironmentEntity;
import ru.hh.career.solution.professionalenvironmentandspecialization.entity.SpecializationEntity;

import javax.inject.*;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Singleton
@Transactional
public class ParserService {
    private final ProfessionalEnvironmentDao professionalEnvironmentDao;
    private final SpecializationDao specializationDao;

    @Inject
    public ParserService(ProfessionalEnvironmentDao professionalEnvironmentDao, SpecializationDao specializationDao) {
        this.professionalEnvironmentDao = professionalEnvironmentDao;
        this.specializationDao = specializationDao;
    }

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
            for (SpecializationsDto specializationsDto: professionalEnvironmentDto.getSpecializations()){
                SpecializationEntity specializationEntity =
                        new SpecializationEntity(
                                specializationsDto.getIdSpecialization(),
                                specializationsDto.getName(),
                                specializationsDto.getLaboring(),
                                professionalEnvironmentDto.getId()
                        );
                specializationDao.save(specializationEntity);
            }
        }
    }
}

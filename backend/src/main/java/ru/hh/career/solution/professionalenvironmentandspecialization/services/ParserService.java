package ru.hh.career.solution.professionalenvironmentandspecialization.services;

import ru.hh.career.solution.professionalenvironmentandspecialization.dao.ProfessionalEnvironmentDao;
import ru.hh.career.solution.professionalenvironmentandspecialization.dao.SpecializationDao;
import ru.hh.career.solution.professionalenvironmentandspecialization.dto.ParserProfessionalEnvironmentAndSpecialization;
import ru.hh.career.solution.professionalenvironmentandspecialization.dto.ProfessionalEnvironmentDto;
import ru.hh.career.solution.professionalenvironmentandspecialization.dto.SpecializationsDto;
import ru.hh.career.solution.professionalenvironmentandspecialization.entity.ProfessionalEnvironmentEntity;
import ru.hh.career.solution.professionalenvironmentandspecialization.entity.SpecializationEntity;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ParserService {
//    private final SessionFactory sessionFactory;
//
//    public ParserService(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    private final ProfessionalEnvironmentDao professionalEnvironmentDao;
    private final SpecializationDao specializationDao;

    public ParserService(ProfessionalEnvironmentDao professionalEnvironmentDao, SpecializationDao specializationDao) {
        this.professionalEnvironmentDao = professionalEnvironmentDao;
        this.specializationDao = specializationDao;
    }


    public void mainParser() throws IOException, ExecutionException, InterruptedException {
        ParserProfessionalEnvironmentAndSpecialization parserProfessionalEnvironmentAndSpecialization = new ParserProfessionalEnvironmentAndSpecialization();
        ProfessionalEnvironmentDto[] professionalEnvironmentDto = parserProfessionalEnvironmentAndSpecialization.parse();
        for (ProfessionalEnvironmentDto i : professionalEnvironmentDto) {
            ProfessionalEnvironmentEntity professionalEnvironmentEntity = new ProfessionalEnvironmentEntity(i.getId(), i.getName());
            professionalEnvironmentDao.save(professionalEnvironmentEntity);
            for (SpecializationsDto j: i.getSpecialization()){
                SpecializationEntity specializationEntity = new SpecializationEntity(j.getIdSpecialization(), j.getName(), j.getLaboring(), i.getId());
                specializationDao.save(specializationEntity);
            }
        }
    }
}

package ru.hh.career.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.hh.career.solution.dao.AdviserDao;
import ru.hh.career.solution.mapper.AdviserMapper;
import ru.hh.career.solution.mapper.AreaMapper;
import ru.hh.career.solution.mapper.EducationalInstitutionMapper;
import ru.hh.career.solution.mapper.EducationalPeriodMapper;
import ru.hh.career.solution.mapper.ProfessionalAssociationMapper;
import ru.hh.career.solution.mapper.ProfessionalSkillMapper;
import ru.hh.career.solution.resource.AdviserResource;
import ru.hh.career.solution.service.AdviserService;
import ru.hh.nab.hibernate.NabHibernateCommonConfig;

@Configuration
@EnableTransactionManagement
@Import({
  BeanConfig.class,
  NabHibernateCommonConfig.class,
  AdviserDao.class,
  AdviserService.class,
  AdviserResource.class,
  AdviserMapper.class,
  AreaMapper.class,
  EducationalInstitutionMapper.class,
  EducationalPeriodMapper.class,
  ProfessionalSkillMapper.class,
  ProfessionalAssociationMapper.class
})
public class JerseyConfig {
}

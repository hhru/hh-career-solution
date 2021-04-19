package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.entity.Adviser;

import javax.inject.Singleton;
import java.util.stream.Collectors;

@Singleton
public class AdviserMapper {

  private final AreaMapper areaMapper;
  private final EducationalInstitutionMapper educationalInstitutionMapper;
  private final ProfessionalSkillMapper professionalSkillMapper;
  private final ProfessionalAssociationMapper professionalAssociationMapper;

  public AdviserMapper(AreaMapper areaMapper, EducationalInstitutionMapper educationalInstitutionMapper,
                       ProfessionalSkillMapper professionalSkillMapper, ProfessionalAssociationMapper professionalAssociationMapper) {
    this.areaMapper = areaMapper;
    this.educationalInstitutionMapper = educationalInstitutionMapper;
    this.professionalSkillMapper = professionalSkillMapper;
    this.professionalAssociationMapper = professionalAssociationMapper;
  }

  public AdviserDto map(Adviser adviser) {
    return adviser == null ? null : new AdviserDto(
      adviser.getId(),
      adviser.getName(),
      adviser.getSurname(),
      adviser.getConsultation(),
      adviser.getExperience(),
      adviser.getCareerPractice(),
      adviser.getCustomerType(),
      adviser.getProblemType(),
      adviser.getCreated(),
      adviser.getUpdated(),
      areaMapper.map(adviser.getArea()),
      adviser.getEducationalSet().stream().map(educationalInstitutionMapper::map).collect(Collectors.toList()),
      adviser.getProfessionalSkillSet().stream().map(professionalSkillMapper::map).collect(Collectors.toList()),
      adviser.getProfessionalAssociationSet().stream().map(professionalAssociationMapper::map).collect(Collectors.toList())
    );
  }
}

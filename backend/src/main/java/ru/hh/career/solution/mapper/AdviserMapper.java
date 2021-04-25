package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.entity.Adviser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public final class AdviserMapper {

  public static AdviserDto map(Adviser adviser) {
    return adviser == null ? null : new AdviserDto(
      adviser.getId(),
      adviser.getName(),
      adviser.getSurname(),
      adviser.getConsultation().getDescription(),
      adviser.getExperience().getDescription(),
      adviser.getCareerPractice().getDescription(),
      adviser.getCustomerType().getDescription(),
      adviser.getProblemType().getDescription(),
      adviser.getCreated(),
      adviser.getUpdated(),
      AreaMapper.map(adviser.getArea()),
      new ArrayList<>(adviser.getEducationalSet()),
      adviser.getProfessionalSkillSet().stream().map(ProfessionalSkillMapper::map).collect(Collectors.toList()),
      adviser.getProfessionalAssociationSet().stream().map(ProfessionalAssociationMapper::map).collect(Collectors.toList())
    );
  }

  public static Adviser map(AdviserDto adviser) {
    return adviser == null ? null : new Adviser(
      adviser.getId(),
      adviser.getName(),
      adviser.getSurname(),
      adviser.getArea() == null ? null : AreaMapper.map(adviser.getArea()),
      adviser.getEducationalList() == null ? null : new HashSet<>(adviser.getEducationalList()),
      adviser.getProfessionalSkillList() == null ? null : adviser.getProfessionalSkillList().stream()
        .map(ProfessionalSkillMapper::map).collect(Collectors.toSet()),
      adviser.getProfessionalAssociationList() == null ? null : adviser.getProfessionalAssociationList().stream()
        .map(ProfessionalAssociationMapper::map).collect(Collectors.toSet()),
      Adviser.Consultation.valueOf(adviser.getConsultation()),
      Adviser.Experience.valueOf(adviser.getExperience()),
      Adviser.CareerPractice.valueOf(adviser.getCareerPractice()),
      Adviser.CustomerType.valueOf(adviser.getCustomerType()),
      Adviser.ProblemType.valueOf(adviser.getProblemType()),
      LocalDateTime.now(),
      LocalDateTime.now()
    );
  }

}

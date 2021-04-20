package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.entity.Adviser;

import java.util.stream.Collectors;

public final class AdviserMapper {

  public static AdviserDto map(Adviser adviser) {
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
      AreaMapper.map(adviser.getArea()),
      adviser.getProfessionalSkillList().stream().map(ProfessionalSkillMapper::map).collect(Collectors.toList()),
      adviser.getProfessionalAssociationList().stream().map(ProfessionalAssociationMapper::map).collect(Collectors.toList())
    );
  }

}

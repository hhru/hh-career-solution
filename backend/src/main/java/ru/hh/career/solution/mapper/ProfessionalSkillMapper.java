package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.ProfessionalSkillDto;
import ru.hh.career.solution.entity.AdviserToProfessionalSkill;

import javax.inject.Singleton;

@Singleton
public class ProfessionalSkillMapper {

  public ProfessionalSkillDto map(AdviserToProfessionalSkill adviser) {
    return adviser == null ? null : new ProfessionalSkillDto(
      adviser.getProfessionalSkill().getId(),
      adviser.getProfessionalSkill().getName()
    );
  }
}

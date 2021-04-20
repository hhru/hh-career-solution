package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.ProfessionalSkillDto;
import ru.hh.career.solution.entity.ProfessionalSkill;

public final class ProfessionalSkillMapper {

  public static ProfessionalSkillDto map(ProfessionalSkill professionalSkill) {
    return professionalSkill == null ? null : new ProfessionalSkillDto(
      professionalSkill.getId(),
      professionalSkill.getName());
  }

}

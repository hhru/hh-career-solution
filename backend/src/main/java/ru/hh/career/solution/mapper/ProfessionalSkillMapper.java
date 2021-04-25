package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.ProfessionalSkillDto;
import ru.hh.career.solution.entity.ProfessionalSkill;

import java.time.LocalDateTime;

public final class ProfessionalSkillMapper {

  public static ProfessionalSkillDto map(ProfessionalSkill professionalSkill) {
    return professionalSkill == null ? null : new ProfessionalSkillDto(
      professionalSkill.getId(),
      professionalSkill.getName());
  }

  public static ProfessionalSkill map(ProfessionalSkillDto professionalSkill) {
    return professionalSkill == null ? null : new ProfessionalSkill(
      professionalSkill.getId(),
      professionalSkill.getName(),
      LocalDateTime.now(),
      LocalDateTime.now());
  }

}

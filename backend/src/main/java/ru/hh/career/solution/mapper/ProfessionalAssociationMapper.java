package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.ProfessionalAssociationDto;
import ru.hh.career.solution.entity.ProfessionalAssociation;

import java.time.LocalDateTime;

public final class ProfessionalAssociationMapper {

  public static ProfessionalAssociationDto map(ProfessionalAssociation professionalAssociation) {
    return professionalAssociation == null ? null : new ProfessionalAssociationDto(
      professionalAssociation.getId(),
      professionalAssociation.getName());
  }

  public static ProfessionalAssociation map(ProfessionalAssociationDto professionalAssociation) {
    return professionalAssociation == null ? null : new ProfessionalAssociation(
      professionalAssociation.getId(),
      professionalAssociation.getName(),
      LocalDateTime.now(),
      LocalDateTime.now());
  }

}

package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.ProfessionalAssociationDto;
import ru.hh.career.solution.entity.ProfessionalAssociation;

public final class ProfessionalAssociationMapper {

  public static ProfessionalAssociationDto map(ProfessionalAssociation professionalAssociation) {
    return professionalAssociation == null ? null : new ProfessionalAssociationDto(
      professionalAssociation.getId(),
      professionalAssociation.getName());
  }

}

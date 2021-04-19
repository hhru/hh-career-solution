package ru.hh.career.solution.mapper;

import ru.hh.career.solution.dto.ProfessionalAssociationDto;
import ru.hh.career.solution.entity.AdviserToProfessionalAssociation;

import javax.inject.Singleton;

@Singleton
public class ProfessionalAssociationMapper {

  public ProfessionalAssociationDto map(AdviserToProfessionalAssociation adviser) {
    return adviser == null ? null : new ProfessionalAssociationDto(
      adviser.getProfessionalAssociation().getId(),
      adviser.getProfessionalAssociation().getName()
    );
  }
}

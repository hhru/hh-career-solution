package ru.hh.career.solution.professionalenvironment.resource;

import ru.hh.career.solution.professionalenvironment.services.ParserSpecializationService;

import javax.inject.Inject;

//@Path("/download")
public class ParserResource {
  private final ParserSpecializationService parserSpecializationService;

  @Inject
  public ParserResource(ParserSpecializationService parserSpecializationService) {
    this.parserSpecializationService = parserSpecializationService;
  }

//  @GET
//  @Path("/specialization")
//  public void getSpecialization() {
//    try {
//      parserSpecializationService.parseSpecialization();
//    } catch (IOException | ExecutionException | InterruptedException e) {
//      e.printStackTrace();
//    }
//  }
}

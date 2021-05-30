package ru.hh.career.solution.resource;

import ru.hh.career.solution.area.service.ParserAreaService;
import ru.hh.career.solution.professionalenvironment.services.ParserSpecializationService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Path("/download")
public class ParserResource {
  private final ParserSpecializationService parserSpecializationService;
  private final ParserAreaService parserAreaService;

  @Inject
  public ParserResource(ParserSpecializationService parserSpecializationService, ParserAreaService parserAreaService) {
    this.parserSpecializationService = parserSpecializationService;
    this.parserAreaService = parserAreaService;
  }

  @POST
  @Path("/specialization")
  public void getSpecialization() {
    try {
      parserSpecializationService.parseSpecialization();
    } catch (IOException | ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @POST
  @Path("/area")
  public void getArea() {
    try {
      parserAreaService.parseArea();
    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @POST
  @Path("/init")
  public void getAll() {
    try {
      parserAreaService.parseArea();
      parserSpecializationService.parseSpecialization();
    } catch (IOException | ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}

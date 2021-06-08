package ru.hh.career.solution.resource;

import ru.hh.career.solution.service.ParserAreaService;
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
  public void downloadSpecialization() throws IOException, ExecutionException, InterruptedException {
    parserSpecializationService.parseSpecialization();
  }

  @POST
  @Path("/area")
  public void downloadArea() throws ExecutionException, InterruptedException {
    parserAreaService.parseArea();
  }

  @POST
  @Path("/init")
  public void getAll() throws ExecutionException, InterruptedException, IOException {
    parserAreaService.parseArea();
    parserSpecializationService.parseSpecialization();
  }
}

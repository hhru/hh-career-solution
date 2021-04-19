package ru.hh.career.solution.resource;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.dto.PageResponseDto;
import ru.hh.career.solution.mapper.AdviserMapper;
import ru.hh.career.solution.service.AdviserService;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;

@Path("/advisers")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class AdviserResource {

  private final AdviserService adviserService;
  private final AdviserMapper adviserMapper;

  public AdviserResource(AdviserService adviserService, AdviserMapper adviserMapper) {
    this.adviserService = adviserService;
    this.adviserMapper = adviserMapper;
  }

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  public PageResponseDto getAdvisers(@DefaultValue("100") @QueryParam("limit") Integer limit,
                                     @DefaultValue("0") @QueryParam("page") Integer page) {

    return new PageResponseDto(adviserService.getAdvisers(limit, page).stream().
      map(adviserMapper::map).
      collect(Collectors.toList()),
      adviserService.getPagesCount(limit));
  }

  @GET
  @Path(value = "/{id:[\\d]+}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public AdviserDto getAdviserById(@PathParam(value = "id") Integer id) {
    return adviserMapper.map(adviserService.getAdviserById(id));
  }

}

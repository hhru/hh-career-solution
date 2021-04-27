package ru.hh.career.solution.resource;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.dto.PageResponseDto;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.mapper.AdviserMapper;
import ru.hh.career.solution.service.AdviserService;

import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;

@Path("/advisers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class AdviserResource {

  private final AdviserService adviserService;

  public AdviserResource(AdviserService adviserService) {
    this.adviserService = adviserService;
  }

  @GET
  public PageResponseDto getAdvisers(@DefaultValue("20") @QueryParam("per_page") Integer perPage,
                                     @DefaultValue("0") @QueryParam("page") Integer page) {

    return new PageResponseDto(adviserService.getAdvisers(perPage, page).stream().
      map(AdviserMapper::map).
      collect(Collectors.toList()),
      adviserService.getPagesCount(perPage));
  }

  @GET
  @Path(value = "/{id:[\\d]+}")
  public AdviserDto getAdviserById(@PathParam(value = "id") Integer id) {
    Adviser adviser = adviserService.getAdviserById(id);
    return AdviserMapper.map(adviser);
  }

  @POST
  public AdviserDto.AdviserIdDto createAdviser(@Valid AdviserDto request) {
    Adviser adviser = adviserService.save(AdviserMapper.map(request));
    return new AdviserDto.AdviserIdDto(adviser.getId());
  }

  @PUT
  public AdviserDto updateAdviser(@Valid AdviserDto request) {
    Adviser adviser = adviserService.update(AdviserMapper.map(request));
    return AdviserMapper.map(adviser);
  }
}

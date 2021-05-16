package ru.hh.career.solution.resource;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.dto.IdDto;
import ru.hh.career.solution.dto.PageResponseDto;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.exception.LocalizableException;
import ru.hh.career.solution.mapper.AdviserMapper;
import ru.hh.career.solution.service.AdviserService;

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
import java.util.List;
import java.util.stream.Collectors;

@Path("/advisers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdviserResource {

  private final AdviserService adviserService;

  public AdviserResource(AdviserService adviserService) {
    this.adviserService = adviserService;
  }

  @GET
  public PageResponseDto<AdviserDto> getAdvisers(@DefaultValue("100") @QueryParam("per_page") Integer perPage,
                                                 @DefaultValue("0") @QueryParam("page") Integer page) {
    Long countAdvisers = adviserService.getCountAdvisers();
    List<Adviser> adviserList = adviserService.getAdvisers(perPage, page);
    return new PageResponseDto<>(adviserList.stream().
      map(AdviserMapper::mapToAdviserDto).
      collect(Collectors.toList()),
      countAdvisers,
      perPage,
      page);
  }

  @GET
  @Path(value = "/{id:[\\d]+}")
  public AdviserDto getAdviserById(@PathParam(value = "id") Integer id) {
    Adviser adviser = null;
    try {
      adviser = adviserService.getAdviserById(id);
    } catch (LocalizableException e) {
      e.rethrowAsWebApplicationException();
    }
    return AdviserMapper.mapToAdviserDto(adviser);
  }

  @POST
  public IdDto createAdviser(@Valid AdviserDto request) {
    // TODO [back-14] fix account id
    Adviser adviser = AdviserMapper.mapToAdviser(request, null);
    adviserService.saveOrUpdate(adviser);
    return new IdDto(adviser.getId());
  }

  @PUT
  public void updateAdviser(@Valid AdviserDto request) {
    try {
      // TODO [back-14] fix account id
      adviserService.saveOrUpdate(AdviserMapper.mapToAdviser(request, null));
    } catch (LocalizableException e) {
      e.rethrowAsWebApplicationException();
    }
  }
}

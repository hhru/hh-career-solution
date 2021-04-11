package ru.hh.career.solution.resource;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.dto.PageResponseDto;
import ru.hh.career.solution.mapper.AdviserMapper;
import ru.hh.career.solution.service.AdviserService;

import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public PageResponseDto getAll(@DefaultValue("100") @QueryParam("limit") Integer limit,
                                  @DefaultValue("0") @QueryParam("page") Integer page,
                                  @QueryParam("area_id") Integer areaId,
                                  @QueryParam("professionalFieldsId") Integer professionalFieldsId) {

        return new PageResponseDto(adviserService.getAll(limit, page).stream().
                map(adviserMapper::map).
                collect(Collectors.toList()),
                adviserService.getPagesCount(limit));
    }

    @GET
    @Path(value = "/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AdviserDto getAdviserById(@PathParam(value = "id") Integer id) {
        return adviserMapper.map(adviserService.get(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAdviser(AdviserDto adviserDto) {
        AdviserDto adviserDtoCreated = adviserMapper.map(adviserService.create(adviserMapper.map(adviserDto)));
        return Response.status(Response.Status.CREATED).entity(adviserDtoCreated.getAdviserId()).build();
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AdviserDto updateAdviser(@Valid AdviserDto adviserDto) {
        return adviserMapper.map(adviserService.update(adviserMapper.map(adviserDto)));
    }

}

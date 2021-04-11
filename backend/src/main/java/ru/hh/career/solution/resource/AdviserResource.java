package ru.hh.career.solution.resource;

import ru.hh.career.solution.dto.AdviserDto;
import ru.hh.career.solution.entity.Adviser;
import ru.hh.career.solution.mapper.AdviserMapper;
import ru.hh.career.solution.service.AdviserService;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/adviser")
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
    public Response getAll(@QueryParam("limit") Integer limit,
                           @QueryParam("page") Integer page) {
        List<Adviser> adviserList = adviserService.getAll(limit, page);
        List<AdviserDto> adviserDtoList = adviserList.stream().
                map(adviserMapper::map).
                collect(Collectors.toList());

        return Response.ok().entity(adviserDtoList).build();
    }

    @GET
    @Path(value = "/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployerById(@PathParam(value = "id") Integer id) {
        Adviser adviser = adviserService.get(id);
        return Response.ok().entity(adviser).build();
    }
}

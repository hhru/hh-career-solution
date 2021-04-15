package ru.hh.career.solution.exceptionmapper;

import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import ru.hh.career.solution.exception.LocalizableException;

public class LocalizableExceptionMapper implements ExceptionMapper<LocalizableException> {

  @Override
  public Response toResponse(LocalizableException exception) {
    return Response.status(exception.getStatusCode())
      .entity(Map.of("code", exception.getErrorCode().ordinal())).build();
  }
}

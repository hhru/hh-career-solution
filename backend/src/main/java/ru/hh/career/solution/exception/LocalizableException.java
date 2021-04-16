package ru.hh.career.solution.exception;

import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * <strong>DO NOT USE THIS EXCEPTION FOR INTERAPPLICATIONAL PURPOSE</strong>
 * <p> {@code LocalizableException} intended as a way to communicate with frontend application uniformly.
 */
public class LocalizableException extends RuntimeException {

  public static final int DEFAULT_STATUS_CODE = Status.BAD_REQUEST.getStatusCode();

  private int httpStatusCode;

  private ErrorCode errorCode;

  public LocalizableException(ErrorCode errorCode) {
    this(errorCode, DEFAULT_STATUS_CODE);
  }

  public LocalizableException(ErrorCode errorCode, Status status) {
    this(errorCode, status.getStatusCode());
  }

  public LocalizableException(ErrorCode errorCode, int httpStatusCode) {
    super();
    this.errorCode = errorCode;
    this.httpStatusCode = httpStatusCode;
  }

  public void rethrowAsWebApplicationException() throws WebApplicationException {
    throw new WebApplicationException(Response.status(httpStatusCode)
      .entity(Map.of("code", errorCode.ordinal())).build());
  }

  public int getStatusCode() {
    return httpStatusCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }
}

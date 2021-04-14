package ru.hh.career.solution.exception;

import javax.ws.rs.core.Response.Status;

/**
 * <strong>DO NOT USE THIS EXCEPTION FOR INTERAPPLICATIONAL PURPOSE</strong>
 * <p> {@code LocalizableException} intended as a way to communicate with frontend application uniformly.
 */
public class LocalizableException extends RuntimeException {

  private static final long serialVersionUID = 4325482881823157625L;

  public static final int DEFAULT_STATUS_CODE = Status.BAD_REQUEST.getStatusCode();

  private int httpStatusCode;

  private ErrorCode errorCode;

  {
    httpStatusCode = DEFAULT_STATUS_CODE;
  }

  public LocalizableException(ErrorCode errorCode) {
    super();
    this.errorCode = errorCode;
  }

  public LocalizableException(ErrorCode errorCode, Status status) {
    super();
    this.errorCode = errorCode;
    httpStatusCode = status.getStatusCode();
  }

  public LocalizableException(ErrorCode errorCode, int httpStatusCode) {
    super();
    this.errorCode = errorCode;
    this.httpStatusCode = httpStatusCode;
  }

  public int getStatusCode() {
    return httpStatusCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }
}

package ru.hh.career.solution.exception;

/**
 * Unique code of error that could be localized on frontend.
 * Be sure that fronenders are aware of new error to localize.
 */
public enum ErrorCode {
  RESERVED,
  USER_EXISTS_PRIOR_TO_REGISTRATION,
  NOT_FOUND,
}

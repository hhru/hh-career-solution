package ru.hh.career.solution.exception;

/**
 * Unique code of error that could be localized on frontend.
 * Be sure that frontenders are aware of new error to localize.
 */
public enum ErrorCode {
  RESERVED,
  USER_EXISTS_PRIOR_TO_REGISTRATION,
  NOT_FOUND,
  INTERNAL,
  CUSTOMER_SHOULD_BE_AUTHENTICATED_TO_SAVE_PROBLEM,
}

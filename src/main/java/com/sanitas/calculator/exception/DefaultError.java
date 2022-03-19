package com.sanitas.calculator.exception;

public class DefaultError {
  private final String field;
  private final String error;

  public DefaultError(String field, String error) {
    this.field = field;
    this.error = error;
  }

  public String getField() {
    return field;
  }

  public String getError() {
    return error;
  }

}

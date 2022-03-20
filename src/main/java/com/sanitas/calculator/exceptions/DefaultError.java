package com.sanitas.calculator.exceptions;

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

  @Override
  public String toString() {
    return "DefaultError{" +
            "field='" + field + '\'' +
            ", error='" + error + '\'' +
            '}';
  }
}

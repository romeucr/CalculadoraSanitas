package com.sanitas.calculator.exceptions;

import io.corp.calculator.TracerImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

private final MessageSource messageSource;
private final TracerImpl tracerAPI;

  ExceptionHandlerAdvice(MessageSource messageSource, TracerImpl tracerAPI) {
    this.messageSource = messageSource;
    this.tracerAPI = tracerAPI;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<List<DefaultError>> handle(MethodArgumentNotValidException exception) {
    final List<DefaultError> errorList = new ArrayList<>();
    final List<FieldError> fieldErrorsList = exception.getBindingResult().getFieldErrors();

    fieldErrorsList.forEach(e -> {
      final String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
      final DefaultError error = new DefaultError(e.getField(), message);
      errorList.add(error);
      tracerAPI.trace(error);
    });

    return ResponseEntity.badRequest().body(errorList);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  protected ResponseEntity<DefaultError> handle(HttpMessageNotReadableException exception) {
    final DefaultError error = new DefaultError("undefined", "Error deserializing object.");
    tracerAPI.trace(error);
    return ResponseEntity.badRequest().body(error);
  }

}

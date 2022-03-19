package com.sanitas.calculator.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

  @Autowired
  MessageSource messageSource;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<?> handle(MethodArgumentNotValidException exception) {
    List<DefaultError> errorList = new ArrayList<>();
    List<FieldError> fieldErrorsList = exception.getBindingResult().getFieldErrors();

    fieldErrorsList.forEach(e -> {
      String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
      DefaultError error = new DefaultError(e.getField(), message);
      errorList.add(error);
    });

    return ResponseEntity.badRequest().body(errorList);
  }
}

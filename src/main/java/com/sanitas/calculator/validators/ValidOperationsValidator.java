package com.sanitas.calculator.validators;

import com.sanitas.calculator.enums.OperationEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ValidOperationsValidator implements ConstraintValidator<ValidOperations, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Predicate<OperationEnum> validOperation = operationEnum -> operationEnum.name().equals(value);
    return Stream.of(OperationEnum.values()).anyMatch(validOperation);
  }
}

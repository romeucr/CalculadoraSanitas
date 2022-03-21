package com.sanitas.calculator.validators;

import com.sanitas.calculator.enums.OperationTypeEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ValidOperationsValidator implements ConstraintValidator<ValidOperations, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Predicate<OperationTypeEnum> validOperation = operationEnum -> operationEnum.name().equals(value);
    return Stream.of(OperationTypeEnum.values()).anyMatch(validOperation);
  }
}

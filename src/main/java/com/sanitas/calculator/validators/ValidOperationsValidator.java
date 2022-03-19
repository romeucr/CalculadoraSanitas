package com.sanitas.calculator.validators;

import com.sanitas.calculator.enums.OperationEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidOperationsValidator implements ConstraintValidator<ValidOperations, OperationEnum> {

  @Override
  public boolean isValid(OperationEnum value, ConstraintValidatorContext context) {

    return value.equals(OperationEnum.SUM) || value.equals(OperationEnum.SUBTRACTION);
  }
}

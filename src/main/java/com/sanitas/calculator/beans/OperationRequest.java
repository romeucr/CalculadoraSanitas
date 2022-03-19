package com.sanitas.calculator.beans;

import com.sanitas.calculator.enums.OperationEnum;
import com.sanitas.calculator.validator.ValidOperations;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OperationRequest {

  @NotNull
  private BigDecimal number1;

  @NotNull
  private BigDecimal number2;

  @NotNull
  @ValidOperations
  private OperationEnum operation;

  public BigDecimal getNumber1() {
    return number1;
  }

  public BigDecimal getNumber2() {
    return number2;
  }

  public OperationEnum getOperation() {
    return operation;
  }

  public void setNumber1(BigDecimal number1) {
    this.number1 = number1;
  }

  public void setNumber2(BigDecimal number2) {
    this.number2 = number2;
  }

  public void setOperation(OperationEnum operation) {
    this.operation = operation;
  }
}

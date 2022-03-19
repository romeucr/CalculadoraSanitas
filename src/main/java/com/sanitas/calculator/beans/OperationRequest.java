package com.sanitas.calculator.beans;

import com.sanitas.calculator.enums.OperationEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OperationRequest {

  @NotNull
  private BigDecimal number1;

  @NotNull
  private BigDecimal number2;

  @NotNull
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
}

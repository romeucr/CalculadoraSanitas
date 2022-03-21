package com.sanitas.calculator.strategies;

import java.math.BigDecimal;

public class Calculation {
  private final MathOperation operation;

  public Calculation(MathOperation operation) {
    this.operation = operation;
  }

  public BigDecimal execute(BigDecimal number1, BigDecimal number2){
    return operation.calculate(number1, number2);
  }
}

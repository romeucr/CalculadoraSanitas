package com.sanitas.calculator.strategy;

import java.math.BigDecimal;

public class Calculation {
  private final MathOperations operation;

  public Calculation(MathOperations operation) {
    this.operation = operation;
  }

  public BigDecimal execute(BigDecimal number1, BigDecimal number2){
    return operation.calculate(number1, number2);
  }
}

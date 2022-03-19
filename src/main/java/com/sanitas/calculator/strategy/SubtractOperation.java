package com.sanitas.calculator.strategy;

import java.math.BigDecimal;

public class SubtractOperation implements MathOperations {
  @Override
  public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
    return number1.subtract(number2);
  }
}

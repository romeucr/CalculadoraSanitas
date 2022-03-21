package com.sanitas.calculator.strategies;

import java.math.BigDecimal;

public class SubtractionOperation implements MathOperations {
  @Override
  public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
    return number1.subtract(number2);
  }
}

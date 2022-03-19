package com.sanitas.calculator.strategy;

import java.math.BigDecimal;

public class SumOperation implements MathOperations {
  @Override
  public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
    return number1.add(number2);
  }
}

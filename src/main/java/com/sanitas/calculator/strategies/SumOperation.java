package com.sanitas.calculator.strategies;

import java.math.BigDecimal;

public class SumOperation implements MathOperation {
  @Override
  public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
    return number1.add(number2);
  }
}

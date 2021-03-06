package com.sanitas.calculator.strategies;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CalculationTest {

  @Test
  void shouldCalculateSumOperation() {
    final Calculation sumOperation = new Calculation(new SumOperation());
    final BigDecimal actualResult = sumOperation.execute(new BigDecimal("10"), new BigDecimal("15"));
    final BigDecimal expectedResult = new BigDecimal("25");
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void shouldCalculateSubtractOperation() {
    final Calculation sumOperation = new Calculation(new SubtractionOperation());
    final BigDecimal actualResult = sumOperation.execute(new BigDecimal("10"), new BigDecimal("15"));
    final BigDecimal expectedResult = new BigDecimal("-5");
    Assertions.assertEquals(expectedResult, actualResult);
  }
}

package com.sanitas.calculator.services;

import com.sanitas.calculator.enums.OperationTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
class CalculatorServiceTest {

  @InjectMocks
  private CalculatorService calculatorService;

  @Test
  void shouldCalculateSumWhenRequested() {
    final BigDecimal actualResult =
            calculatorService.defineAndCalculateOperation(new BigDecimal("10"),
                                                          new BigDecimal("15"), OperationTypeEnum.SUM);

    final BigDecimal expectedResult = new BigDecimal("25");
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void shouldCalculateSubtractionWhenRequested() {
    final BigDecimal actualResult =
            calculatorService.defineAndCalculateOperation(new BigDecimal("10"),
                    new BigDecimal("15"), OperationTypeEnum.SUBTRACTION);

    final BigDecimal expectedResult = new BigDecimal("-5");
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void shouldCalculateSumWithPrecisionAndScaleWhenRequested() {
    final BigDecimal actualResult =
            calculatorService.defineAndCalculateOperation(new BigDecimal("1101310.16253"),
                    new BigDecimal("12315.123"), OperationTypeEnum.SUBTRACTION);

    final int expectedPrecision = 12;
    Assertions.assertEquals(expectedPrecision, actualResult.precision());

    final int expectedScale= 5;
    Assertions.assertEquals(expectedScale, actualResult.scale());
  }
}

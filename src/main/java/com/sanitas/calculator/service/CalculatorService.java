package com.sanitas.calculator.service;

import com.sanitas.calculator.enums.OperationEnum;
import com.sanitas.calculator.strategy.Calculation;
import com.sanitas.calculator.strategy.SubtractOperation;
import com.sanitas.calculator.strategy.SumOperation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {

  public BigDecimal defineAndCalculateOperation(final BigDecimal number1, final BigDecimal number2,
                                                 final OperationEnum operation) {
    if (operation.equals(OperationEnum.SUBTRACTION)) {
      final Calculation subtractionOperation = new Calculation(new SubtractOperation());
      return subtractionOperation.execute(number1, number2);
    } else {
      final Calculation sumOperation = new Calculation(new SumOperation());
      return sumOperation.execute(number1, number2);
    }
  }
}

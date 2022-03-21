package com.sanitas.calculator.services;

import com.sanitas.calculator.enums.OperationTypeEnum;
import com.sanitas.calculator.strategies.Calculation;
import com.sanitas.calculator.strategies.SubtractionOperation;
import com.sanitas.calculator.strategies.SumOperation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {

  public BigDecimal defineAndCalculateOperation(final BigDecimal number1, final BigDecimal number2,
                                                 final OperationTypeEnum operation) {
    if (operation.equals(OperationTypeEnum.SUBTRACTION)) {
      final Calculation subtractionOperation = new Calculation(new SubtractionOperation());
      return subtractionOperation.execute(number1, number2);
    } else {
      final Calculation sumOperation = new Calculation(new SumOperation());
      return sumOperation.execute(number1, number2);
    }
  }
}

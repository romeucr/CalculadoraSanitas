package com.sanitas.calculator.strategies;

import java.math.BigDecimal;

public interface MathOperation {

  BigDecimal calculate(BigDecimal number1, BigDecimal number2);
}

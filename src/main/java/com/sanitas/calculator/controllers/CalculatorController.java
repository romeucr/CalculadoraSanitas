package com.sanitas.calculator.controllers;

import com.sanitas.calculator.beans.OperationRequest;
import com.sanitas.calculator.beans.OperationResponse;
import com.sanitas.calculator.enums.OperationEnum;
import com.sanitas.calculator.strategies.Calculation;
import com.sanitas.calculator.strategies.SubtractOperation;
import com.sanitas.calculator.strategies.SumOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

  @PostMapping("/calculate")
  public ResponseEntity<OperationResponse> executeOperation(@RequestBody @Valid OperationRequest operationRequest) {

    final BigDecimal number1 = operationRequest.getNumber1();
    final BigDecimal number2 = operationRequest.getNumber2();
    final OperationEnum operation = operationRequest.getOperation();
    final OperationResponse operationResponse = new OperationResponse();

    if (operation.equals(OperationEnum.SUBTRACT)) {
      final Calculation subtractionOperation = new Calculation(new SubtractOperation());
      operationResponse.setResult(subtractionOperation.execute(number1, number2));
    }

    if (operation.equals(OperationEnum.SUM)) {
      final Calculation sumOperation = new Calculation(new SumOperation());
      operationResponse.setResult(sumOperation.execute(number1, number2));
    }

    return ResponseEntity.ok().body(operationResponse);
  }
}

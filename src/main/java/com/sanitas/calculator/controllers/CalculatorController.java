package com.sanitas.calculator.controllers;

import com.sanitas.calculator.beans.OperationRequest;
import com.sanitas.calculator.beans.OperationResponse;
import com.sanitas.calculator.enums.OperationEnum;
import com.sanitas.calculator.services.CalculatorService;
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

  private final CalculatorService calculatorService;

  CalculatorController(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  @PostMapping("/calculate")
  public ResponseEntity<OperationResponse> executeOperation(@RequestBody @Valid OperationRequest operationRequest) {

    final BigDecimal number1 = operationRequest.getNumber1();
    final BigDecimal number2 = operationRequest.getNumber2();
    final OperationEnum operation = OperationEnum.valueOf(operationRequest.getOperation());
    final OperationResponse operationResponse = new OperationResponse();

    final BigDecimal result = calculatorService.defineAndCalculateOperation(number1, number2, operation);

    operationResponse.setResult(result);

    return ResponseEntity.ok().body(operationResponse);
  }

}

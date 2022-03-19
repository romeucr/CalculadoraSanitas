package com.sanitas.calculator.controller;

import com.sanitas.calculator.beans.OperationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

  @PostMapping("/calculate")
  public ResponseEntity<?> executeOperation(@RequestBody @Valid OperationRequest operationRequest) {

    return ResponseEntity.ok().body("ok!");
  }
}

package com.sanitas.calculator.enums;

public enum OperationEnum {

  SUMA("+"),
  RESTA("-");

  final private String symbol;

  OperationEnum(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }
}

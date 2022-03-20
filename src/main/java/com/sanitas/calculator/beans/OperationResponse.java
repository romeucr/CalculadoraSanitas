package com.sanitas.calculator.beans;

import java.math.BigDecimal;

public class OperationResponse {
  private BigDecimal result;

  public void setResult(BigDecimal result) {
    this.result = result;
  }

  public BigDecimal getResult() {
    return result;
  }
}

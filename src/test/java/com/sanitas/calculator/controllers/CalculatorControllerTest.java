package com.sanitas.calculator.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitas.calculator.beans.OperationRequest;
import com.sanitas.calculator.enums.OperationEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objMapper;

  @Test
  public void shouldCalculateSumWhenValidInputsProvided() throws Exception {
    final OperationRequest operationRequest = new OperationRequest();
    operationRequest.setNumber1(new BigDecimal(10));
    operationRequest.setNumber2(new BigDecimal(15));
    operationRequest.setOperation(OperationEnum.SUM);

    final String jsonBody = objMapper.writeValueAsString(operationRequest);

    final ResultActions result = mockMvc.perform(post("/calculator/calculate")
            .content(jsonBody)
            .contentType(MediaType.APPLICATION_JSON));

    result.andExpect(status().isOk());
    result.andExpect(jsonPath("$.result").value(new BigDecimal(25)));
  }

  @Test
  public void shouldCalculateSubtractionWhenValidInputsProvided() throws Exception {
    final OperationRequest operationRequest = new OperationRequest();
    operationRequest.setNumber1(new BigDecimal(10));
    operationRequest.setNumber2(new BigDecimal(15));
    operationRequest.setOperation(OperationEnum.SUBTRACTION);

    final String jsonBody = objMapper.writeValueAsString(operationRequest);

    final ResultActions result = mockMvc.perform(post("/calculator/calculate")
            .content(jsonBody)
            .contentType(MediaType.APPLICATION_JSON));

    result.andExpect(status().isOk());
    result.andExpect(jsonPath("$.result").value(new BigDecimal(-5)));
  }

  @Test
  public void shouldNotCalculateWhenInvalidOperationProvided() throws Exception {
    final OperationRequest operationRequest = new OperationRequest();
    operationRequest.setNumber1(new BigDecimal(10));
    operationRequest.setNumber2(new BigDecimal(15));

    final String jsonBody = objMapper.writeValueAsString(operationRequest);

    final ResultActions result = mockMvc.perform(post("/calculator/calculate")
            .content(jsonBody)
            .contentType(MediaType.APPLICATION_JSON));

    result.andExpect(status().isBadRequest());
  }
}

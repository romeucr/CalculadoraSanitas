package com.sanitas.calculator.configurator;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfig {

  @Bean
  public TracerImpl getTracerApiInstance() {
    return new TracerImpl();
  }
}

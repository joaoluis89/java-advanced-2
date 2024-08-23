package com.example.demo.gateways.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AlunoPatchNome {

  @NotEmpty
  private String primeiroNome;
  private String sobrenome;
}

package com.example.demo.gateways.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoPatchNome  {

  @NotEmpty
  private String primeiroNome;

  @NotBlank
  @Size(min = 0, max = 30)
  private String sobrenome;

}

package com.example.demo.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String primeiroNome;
  private String sobrenome;
  private String documento;
}

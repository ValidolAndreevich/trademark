package com.example.trademark.domain.entity.valueobject;

import lombok.Data;

@Data
public class TransactionContentDetails {
  private Integer transactionIdentifier;
  private String transactionCode;
  private TransactionData transactionData;
}

package com.example.trademark.domain.entity.valueobject;

import lombok.Data;

@Data
public class Transaction {
  private TransactionHeader transactionHeader;
  private TradeMarkTransactionBody tradeMarkTransactionBody;
}

package com.example.trademark.domain.entity;

import com.example.trademark.domain.entity.valueobject.Transaction;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Trademark {
  @Id
  private String id;
  private Transaction transaction;
}

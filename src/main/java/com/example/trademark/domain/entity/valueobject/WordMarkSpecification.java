package com.example.trademark.domain.entity.valueobject;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class WordMarkSpecification {
  @Indexed
  private String markVerbalElementText;
}

package com.example.trademark.domain.entity.valueobject;

import lombok.Data;
import java.util.List;

@Data
public class ClassDescription {
  private String classNumber;
  private List<String> goodsServicesDescription;
}

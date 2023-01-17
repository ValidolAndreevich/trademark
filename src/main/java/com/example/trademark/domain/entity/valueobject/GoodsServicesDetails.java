package com.example.trademark.domain.entity.valueobject;

import lombok.Data;
import java.util.List;

@Data
public class GoodsServicesDetails {
  private List<ClassDescription> classDescriptions;
}

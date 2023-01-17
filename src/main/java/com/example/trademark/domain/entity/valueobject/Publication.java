package com.example.trademark.domain.entity.valueobject;

import lombok.Data;

@Data
public class Publication {
  private String publicationIdentifier;
  private String publicationSection;
  private String publicationDate;
  private String publicationPage;
}

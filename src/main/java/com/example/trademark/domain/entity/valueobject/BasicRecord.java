package com.example.trademark.domain.entity.valueobject;

import lombok.Data;

@Data
public class BasicRecord {
  private String recordIdentifier;
  private String basicRecordKind;
  private RepresentativeDetails representativeDetails;
  private String recordCurrentStatusCode;
  private String recordCurrentStatusDate;
}

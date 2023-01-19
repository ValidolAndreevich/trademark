package com.example.trademark.domain.entity.valueobject;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class TradeMark {
  private String registrationOfficeCode;
  private String applicationNumber;
  private String applicationDate;
  private String registrationDate;
  private String applicationLanguageCode;
  private String secondLanguageCode;
  private String expiryDate;
  private String markCurrentStatusCode;
  private String markCurrentStatusDate;
  private String kindMark;
  @Indexed
  private String markFeature;
  private boolean tradeDistinctivenessIndicator;
  private WordMarkSpecification wordMarkSpecification;
  private GoodsServicesDetails goodsServicesDetails;
  private ApplicantDetails applicantDetails;
  private RepresentativeDetails representativeDetails;
  private MarkRecordDetails markRecordDetails;
}

package com.example.trademark.domain.entity;

import com.example.trademark.domain.entity.valueobject.GoodsServicesDetails;
import com.example.trademark.domain.entity.valueobject.PublicationDetails;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Trademark {
  @Id
  private String id;
  private String applicationNumber;
  private String applicationDate;
  private String registrationDate;
  private String applicationLanguageCode;
  private String secondLanguageCode;
  private String expiryDate;
  private String kindMark;
  private String markFeature;
  @Indexed
  private String markVerbalElementText;
  private GoodsServicesDetails goodsServicesDetails;
  private PublicationDetails publicationDetails;
}

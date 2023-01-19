package com.example.trademark.domain.service;

import com.example.trademark.adapter.mapper.TrademarkRestMapper;
import com.example.trademark.domain.entity.Trademark;
import com.example.trademark.domain.repository.TrademarkRepository;
import com.example.trademark.models.TrademarkResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class TrademarkService {

  private static final String DEFAULT_TRADEMARK_FEATURE = "Word";
  private final String trademarkNamePath = "transaction.tradeMarkTransactionBody.transactionContentDetails.transactionData.tradeMarkDetails.tradeMark.wordMarkSpecification.markVerbalElementText";
  private final String trademarkFeaturePath = "transaction.tradeMarkTransactionBody.transactionContentDetails.transactionData.tradeMarkDetails.tradeMark.markFeature";
  private final String trademarkDescriptionPath = "transaction.tradeMarkTransactionBody.transactionContentDetails.transactionData.tradeMarkDetails.tradeMark.goodsServicesDetails.goodsServices.classDescriptionDetails.classDescription.goodsServicesDescription";
  private final MongoTemplate mongoTemplate;
  private final TrademarkRepository trademarkRepository;

  public List<TrademarkResponseDto> getAllTrademarks() {
    return TrademarkRestMapper.fromTrademarksToTrademarksResponseDto(trademarkRepository.findAll());
  }

  public List<TrademarkResponseDto> findTrademarkByNameAndFeature(String name) {
    Query query = new Query();
    query.addCriteria(Criteria.where(trademarkNamePath).is(name)
        .and(trademarkFeaturePath).is(DEFAULT_TRADEMARK_FEATURE));
    List<Trademark> trademarkList = mongoTemplate.find(query, Trademark.class);

    if (!trademarkList.isEmpty()){
      return TrademarkRestMapper.fromTrademarksToTrademarksResponseDto(trademarkList);
    }
    return findClosestMatches(name);
  }

  private List<TrademarkResponseDto> findClosestMatches(String text) {
    Query query = new Query();
    query.addCriteria(Criteria.where(trademarkDescriptionPath).regex("\\b" + text + "\\b"));

    return TrademarkRestMapper.fromTrademarksToTrademarksResponseDto(
            mongoTemplate.find(query, Trademark.class));
  }
}

package com.example.trademark.adapter.mapper;

import com.example.trademark.domain.entity.Trademark;
import com.example.trademark.domain.entity.valueobject.TradeMark;
import com.example.trademark.models.TrademarkResponseDto;
import java.util.List;

public class TrademarkRestMapper {

  private TrademarkRestMapper(){

  }

  public static List<TrademarkResponseDto> fromTrademarksToTrademarksResponseDto(
      final List<Trademark> trademarks) {
    return trademarks.stream()
        .map(TrademarkRestMapper::fromTrademarkToTrademarkResponseDto)
        .toList();
  }

  private static TrademarkResponseDto fromTrademarkToTrademarkResponseDto(final Trademark trademark) {
    TrademarkResponseDto trademarkResponseDto = new TrademarkResponseDto();
    trademarkResponseDto.setId(trademark.getId());
    trademarkResponseDto.setApplicationNumber(getTradeMark(trademark).getApplicationNumber().toString());
    trademarkResponseDto.setApplicationDate(getTradeMark(trademark).getApplicationDate());
    trademarkResponseDto.setRegistrationDate(getTradeMark(trademark).getRegistrationDate());
    trademarkResponseDto.setApplicationLanguageCode(getTradeMark(trademark).getApplicationLanguageCode());
    trademarkResponseDto.setExpiryDate(getTradeMark(trademark).getExpiryDate());
    trademarkResponseDto.setTrademarkKind(getTradeMark(trademark).getKindMark());
    trademarkResponseDto.setTrademarkFeature(getTradeMark(trademark).getMarkFeature());
    trademarkResponseDto.setTrademarkName(getTradeMark(trademark).getWordMarkSpecification().getMarkVerbalElementText());
    trademarkResponseDto.setTrademarkDescription(getTradeMark(trademark).getGoodsServicesDetails().getGoodsServices().getClassDescriptionDetails().getClassDescription().getGoodsServicesDescription());

    return trademarkResponseDto;
  }

  private static TradeMark getTradeMark(final Trademark trademark){
    return trademark.getTransaction()
        .getTradeMarkTransactionBody()
        .getTransactionContentDetails()
        .getTransactionData()
        .getTradeMarkDetails()
        .getTradeMark();
  }

}

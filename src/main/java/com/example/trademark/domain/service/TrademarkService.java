package com.example.trademark.domain.service;

import com.example.trademark.domain.entity.Trademark;
import com.example.trademark.domain.repository.TrademarkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class TrademarkService {

  private final TrademarkRepository trademarkRepository;

  public List<Trademark> getAllTrademarks() {
    return trademarkRepository.findAll();
  }

  public List<Trademark> findTrademarks(String text) {
     List<Trademark> trademarks =
         trademarkRepository.findTrademarkByMarkVerbalElementText(text).stream().toList();
    if ((trademarks.stream().anyMatch(Objects::nonNull))) {
      return trademarks;
    }
    return findClosestMatches(text);
  }

  private List<Trademark> findClosestMatches(String text) {
    //todo implement close match search
    return null;
  }
}

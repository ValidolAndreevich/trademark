package com.example.trademark.adapter;

import com.example.trademark.domain.entity.Trademark;
import com.example.trademark.domain.service.TrademarkService;
import com.example.trademark.models.TrademarkResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/v1/trademarks")
@AllArgsConstructor
public class TrademarkController {
  private TrademarkService trademarkService;

  /**
   * Retrieves all trademarks.
   *
   * @return {@link List} of {@link Trademark}
   */
  @GetMapping(path = "/all")
  public List<TrademarkResponseDto> getAllTrademarks() {
    return trademarkService.getAllTrademarks();
  }

  /**
   * Retrieves a trademark matching by text, or list of the closest matches.
   *
   * @param searchString {@link String}
   * @return {@link List} of {@link TrademarkResponseDto}
   */
  @GetMapping
  public List<TrademarkResponseDto> findTrademarks(@RequestParam(value = "searchString")String searchString) {
    return trademarkService.findTrademarkByNameAndFeature(searchString);
  }
}

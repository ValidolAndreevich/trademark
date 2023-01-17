package com.example.trademark.domain.repository;

import com.example.trademark.domain.entity.Trademark;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

/**
 * Trademark repository interface.
 *
 */
public interface TrademarkRepository extends MongoRepository<Trademark, String> {
  /**
   * Retrieves trademark by text.
   *
   * @param markVerbalElementText {@link String}
   * @return {@link Trademark}.
   */
  Optional<Trademark> findTrademarkByMarkVerbalElementText(final String markVerbalElementText);
}

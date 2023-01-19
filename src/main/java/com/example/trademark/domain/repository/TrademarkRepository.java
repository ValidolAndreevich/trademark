package com.example.trademark.domain.repository;

import com.example.trademark.domain.entity.Trademark;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Trademark repository interface.
 *
 */
public interface TrademarkRepository extends MongoRepository<Trademark, String> { }

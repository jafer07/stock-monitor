package com.example.repository.repositories;

import java.util.List;
import java.util.Optional;

import com.example.model.Subscription;

public interface SubscriptionRepository {

   Subscription save(Subscription subscription);

   Optional<Subscription> findById(Long id);

   List<Subscription> findByUserId(String userId);

   List<Subscription> findByStockTicker(String stockTicker);

   void deleteById(Long id);
}

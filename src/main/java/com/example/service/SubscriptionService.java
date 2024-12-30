package com.example.service;


import java.util.List;
import java.util.Optional;

import com.example.model.Subscription;
import com.example.repository.repositories.SubscriptionRepository;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SubscriptionService {

    @Inject
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription createSubscription(String userId, String stockTicker) {
        Subscription subscription = Subscription.create(userId, stockTicker);
        return subscriptionRepository.save(subscription);
    }

    public Subscription getSubscription(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found for ID: " + id));
    }

    public List<Subscription> getSubscriptionByUserId(String userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    public List<Subscription> getSubscriptionByStockTicker(String stockTicker) {
        return subscriptionRepository.findByStockTicker(stockTicker);
    }

    public void deleteSubscription(Long id) {
        if (subscriptionRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Cannot delete. Subscription not found for ID: " + id);
        }
        subscriptionRepository.deleteById(id);
    }

}

package com.example.repository.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.model.Subscription;
import com.example.repository.repositories.SubscriptionRepository;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;

@Singleton
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Subscription save(Subscription subscription) {
        return entityManager.merge(subscription);
    }

    @Override
    public Optional<Subscription> findById(Long id) {
        return Optional
                .ofNullable(entityManager.find(Subscription.class, id));
    }

    @Override
    public List<Subscription> findByUserId(String userId) {
        return entityManager
                .createNamedQuery("Subscription.findByUserId", Subscription.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Subscription> findByStockTicker(String stockTicker) {
        return entityManager
                .createNamedQuery("Subscription.findByStockTicker", Subscription.class)
                .setParameter("stockTicker", stockTicker)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Objects.requireNonNull(id);
        Subscription subscription = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found"));
        entityManager.remove(subscription);
    }
}

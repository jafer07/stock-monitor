package com.example.model;

import java.time.ZonedDateTime;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "stock_ticker")
    private String stockTicker;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    public Subscription() {
    }

    public Subscription(Long id, String userId, String stockTicker, ZonedDateTime createdAt) {
        assertUserId(userId);
        assertStockTicker(stockTicker);

        this.id = id;
        this.userId = userId;
        this.stockTicker = stockTicker;
        this.createdAt = createdAt != null ?
                createdAt :
                ZonedDateTime.now();
    }

    public static Subscription create(String userId, String stockTicker) {
        return new Subscription(null, userId, stockTicker, ZonedDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    private void assertUserId(String userId) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID must not be null or empty");
        }
    }

    private void assertStockTicker(String stockTicker) {
        if (stockTicker == null || stockTicker.isBlank()) {
            throw new IllegalArgumentException("Stock ticker must not be null or empty");
        }
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Subscription)) {
            return false;
        }
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(stockTicker, that.stockTicker) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, stockTicker, createdAt);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", stockTicker='" + stockTicker + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

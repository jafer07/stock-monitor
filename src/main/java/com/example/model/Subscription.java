package com.example.model;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Subscription {

    private Long id;

    private String userId;

    private String stockTicker;

    private ZonedDateTime createdAt;

    public Subscription() {
    }

    public Subscription(Long id, String userId, String stockTicker, ZonedDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.stockTicker = stockTicker;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
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

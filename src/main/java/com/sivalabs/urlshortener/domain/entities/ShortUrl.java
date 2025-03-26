package com.sivalabs.urlshortener.domain.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "short_urls")
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "short_urls_id_gen")
    @SequenceGenerator(name = "short_urls_id_gen", sequenceName = "short_urls_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "short_key", nullable = false, length = 10)
    private String shortKey;

    @Column(name = "original_url", nullable = false, length = Integer.MAX_VALUE)
    private String originalUrl;

    @ColumnDefault("false")
    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate = false;

    @Column(name = "expires_at")
    private Instant expiresAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private com.sivalabs.urlshortener.domain.entities.User createdBy;

    @ColumnDefault("0")
    @Column(name = "click_count", nullable = false)
    private Long clickCount;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortKey() {
        return shortKey;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public com.sivalabs.urlshortener.domain.entities.User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(com.sivalabs.urlshortener.domain.entities.User createdBy) {
        this.createdBy = createdBy;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
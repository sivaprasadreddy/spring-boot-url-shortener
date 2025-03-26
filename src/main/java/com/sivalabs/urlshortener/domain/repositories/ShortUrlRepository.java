package com.sivalabs.urlshortener.domain.repositories;

import com.sivalabs.urlshortener.domain.entities.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    @Query("select su from ShortUrl su where su.isPrivate = false order by su.createdAt desc")
    List<ShortUrl> findPublicShortUrls();
}

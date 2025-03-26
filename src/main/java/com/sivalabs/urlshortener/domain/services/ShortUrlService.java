package com.sivalabs.urlshortener.domain.services;

import com.sivalabs.urlshortener.domain.entities.ShortUrl;
import com.sivalabs.urlshortener.domain.repositories.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlService {


    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public List<ShortUrl> findAllPublicShortUrls() {
        return shortUrlRepository.findPublicShortUrls();
    }
}

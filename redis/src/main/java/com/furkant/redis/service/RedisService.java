package com.furkant.redis.service;

import com.furkant.redis.model.CitiesRedis;
import com.furkant.redis.repository.redis.CitiesRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final CitiesRedisRepository citiesRedisRepository;

    @Cacheable(cacheNames = "cities")
    public void save(CitiesRedis citiesRedis) {
        citiesRedisRepository.save(citiesRedis);
    }

    @Cacheable(cacheNames = "cities")
    public CitiesRedis findById(String id) {
        return citiesRedisRepository.findById(id).orElse(null);
    }


    @CacheEvict(cacheNames = "cities")
    public void clearCache() {
        System.out.println("cache clear successfully");
    }

}

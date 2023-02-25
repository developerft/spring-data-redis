package com.furkant.redis.service;

import com.furkant.redis.model.Cities;
import com.furkant.redis.model.CitiesRedis;
import com.furkant.redis.repository.CitiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CitiesService {

    private static final Integer REDIS_TIME_TO_LIVE_ONE_MONTH_DAY = 30;

    private final CitiesRepository citiesRepository;

    private final RedisService redisService;

    public Cities getCitiesById(Long id) {
        var checkRedis = redisService.findById(id.toString());
        if (Objects.nonNull(checkRedis)) {
            return redisToCitiesConverter(checkRedis);
        }
        return citiesRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldnt find city by id: " + id));
    }

    @Transactional
    public Cities createCities(Cities cities) {
        saveRedis(cities);
        return citiesRepository.save(cities);
    }

    private void saveRedis(Cities cities) {
        redisService.save(getCitiesRedisBuilder(cities));
    }

    private CitiesRedis getCitiesRedisBuilder(Cities cities) {
        return CitiesRedis.builder()
                .expiration(Duration.ofDays(REDIS_TIME_TO_LIVE_ONE_MONTH_DAY).toSeconds())
                .name(cities.getName())
                .plateCode(cities.getPlateCode())
                .id(cities.getId().toString())
                .build();
    }

    private Cities redisToCitiesConverter(CitiesRedis citiesRedis) {
        return Cities.builder()
                .name(citiesRedis.getName())
                .plateCode(citiesRedis.getPlateCode())
                .build();
    }
}

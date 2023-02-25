package com.furkant.redis.repository.redis;

import com.furkant.redis.model.CitiesRedis;
import org.springframework.data.repository.CrudRepository;

public interface CitiesRedisRepository extends CrudRepository<CitiesRedis, String> {
}

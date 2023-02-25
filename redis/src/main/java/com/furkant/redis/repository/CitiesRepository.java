package com.furkant.redis.repository;

import com.furkant.redis.model.Cities;
import org.springframework.data.repository.CrudRepository;

public interface CitiesRepository extends CrudRepository<Cities, Long> {
}

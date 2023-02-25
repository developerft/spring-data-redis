package com.furkant.redis.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.persistence.Id;
import java.io.Serializable;


@Data
@EqualsAndHashCode
@RedisHash(value = "cities")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitiesRedis implements Serializable {
    @Id
    private String id;
    private String plateCode;
    private String name;

    @TimeToLive
    private Long expiration;
}

package com.example.secureapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RateLimiterService {

    private final RedisTemplate<String, Integer> redisTemplate;

    public boolean isAllowed(String key, int limit, String timeUnit) {
        Duration duration = parseDuration(timeUnit);
        String redisKey = "rate_limit:" + key;

        Integer currentCount = redisTemplate.opsForValue().get(redisKey);

        if (currentCount == null) {
            redisTemplate.opsForValue().set(redisKey, 1, duration);
            return true;
        }

        if (currentCount < limit) {
            redisTemplate.opsForValue().increment(redisKey);
            return true;
        }

        return false;
    }

    private Duration parseDuration(String timeUnit) {
        return switch (timeUnit.toLowerCase()) {
            case "second" -> Duration.ofSeconds(1);
            case "minute" -> Duration.ofMinutes(1);
            case "15min" -> Duration.ofMinutes(15);
            case "hour" -> Duration.ofHours(1);
            case "day" -> Duration.ofDays(1);
            default -> Duration.ofHours(1);
        };
    }
}

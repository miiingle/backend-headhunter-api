package net.miiingle.headhunter.api.repositories;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.redis.core.RedisHash;

public interface RedisPingRepository extends KeyValueRepository<RedisPingRepository.RedisPing, String> {

    @Value
    @RedisHash("ping")
    class RedisPing {

        @Id
        String id;

        String value;
    }
}

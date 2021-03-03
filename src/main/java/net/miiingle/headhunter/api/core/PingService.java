package net.miiingle.headhunter.api.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.miiingle.headhunter.api.repositories.PostgresPingRepository;
import net.miiingle.headhunter.api.repositories.RedisPingRepository;
import org.elasticsearch.action.main.MainResponse;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PingService {

    private final PostgresPingRepository postgresPingRepository;
    private final ReactiveElasticsearchClient reactiveElasticsearchClient;
    private final RedisPingRepository redisPingRepository;

    public Mono<Map<String, Object>> pingServer(Map<String, Object> message) {
        log.info("Ping Server");
        return Mono.just(Map.of("message", message, "time", LocalDate.now()));
    }

    public Mono<PostgresPingRepository.PostgresPing> pingPostgres() {
        return postgresPingRepository.findById(1L);
    }

    public Mono<MainResponse> pingElasticsearch() {
      return reactiveElasticsearchClient.info();
    }

    public RedisPingRepository.RedisPing pingRedis() {
        var id = UUID.randomUUID().toString();
        redisPingRepository.save(new RedisPingRepository.RedisPing(id, "Test"+LocalDate.now().toString()));

        return redisPingRepository.findById(id).get();
    }
}

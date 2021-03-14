package net.miiingle.headhunter.api.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.miiingle.headhunter.api.repositories.PostgresPingRepository;
import org.elasticsearch.action.main.MainResponse;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PingService {

    private final PostgresPingRepository postgresPingRepository;
    private final ReactiveElasticsearchClient reactiveElasticsearchClient;
    private final ReactiveRedisOperations<String, RedisPing> redisPingRepository;
    private final WebClient pingServer = WebClient.create("https://jsonplaceholder.typicode.com");

    public Mono<Map<String, Object>> pingServer() {
        log.info("Ping Server");
        return Mono.just(Map.of("message", "Test" + LocalDate.now(), "time", LocalDate.now()));
    }

    public Mono<String> pingOutsideWorld() {
        return pingServer
                .get()
                .uri("/todos/1")
                .accept(MediaType.APPLICATION_JSON).exchangeToMono(r -> r.bodyToMono(String.class));
    }

    public Mono<PostgresPingRepository.PostgresPing> pingPostgres() {
        return postgresPingRepository.findById(1L);
    }

    public Mono<MainResponse> pingElasticsearch() {
      return reactiveElasticsearchClient.info();
    }

    public Mono<RedisPing> pingRedis() {
        var id = "pingKey";
        var redisPing = new RedisPing(id, "Test_"+ LocalDateTime.now().toString());

       return redisPingRepository.opsForValue().getAndSet(id, redisPing);
    }
}

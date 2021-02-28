package net.miiingle.headhunter.api.core;

import lombok.RequiredArgsConstructor;
import net.miiingle.headhunter.api.repositories.PostgresPingRepository;
import org.elasticsearch.action.main.MainResponse;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PingService {

    private final PostgresPingRepository postgresPingRepository;
    private final ReactiveElasticsearchClient reactiveElasticsearchClient;

    public Mono<Map<String, Object>> pingServer(Map<String, Object> message) {
        return Mono.just(Map.of("message", message, "time", LocalDate.now()));
    }

    public Mono<PostgresPingRepository.PostgresPing> pingPostgres() {
        return postgresPingRepository.findById(1L);
    }

    public Mono<MainResponse> pingElasticsearch() {
      return reactiveElasticsearchClient.info();
    }
}

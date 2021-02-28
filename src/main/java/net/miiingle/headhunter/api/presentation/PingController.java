package net.miiingle.headhunter.api.presentation;

import lombok.RequiredArgsConstructor;
import net.miiingle.headhunter.api.core.PingService;
import net.miiingle.headhunter.api.repositories.PostgresPingRepository;
import org.elasticsearch.action.main.MainResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("ping")
@RequiredArgsConstructor
public class PingController {

    private final PingService pingService;

    //curl --header "Content-Type: application/json" --request POST --data '{"ping":"pong"}' http://localhost:8080/ping/server
    @PostMapping("server")
    public Mono<Map<String, Object>> pingServer(@RequestBody Map<String, Object> message) {
        return pingService.pingServer(message);
    }

    //curl --header "Content-Type: application/json" --request POST http://localhost:8080/ping/postgres
    @PostMapping("postgres")
    public Mono<PostgresPingRepository.PostgresPing> pingPostgres() {
        return pingService.pingPostgres();
    }

    //curl --header "Content-Type: application/json" --request POST http://localhost:8080/ping/elasticsearch
    @PostMapping("elasticsearch")
    public Mono<MainResponse> pingElasticsearch() {
        return pingService.pingElasticsearch();
    }
}

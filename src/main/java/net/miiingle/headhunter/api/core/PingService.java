package net.miiingle.headhunter.api.core;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Map;

@Service
public class PingService {

    public Mono<Map<String, Object>> pingServer(Map<String, Object> message) {
        return Mono.just(Map.of("message", message, "time", LocalDate.now()));
    }
}

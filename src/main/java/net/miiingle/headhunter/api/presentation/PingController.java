package net.miiingle.headhunter.api.presentation;

import lombok.RequiredArgsConstructor;
import net.miiingle.headhunter.api.core.PingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController("ping")
@RequiredArgsConstructor
public class PingController {

    private final PingService pingService;

    //curl --header "Content-Type: application/json" --request POST --data '{"ping":"pong"}' http://localhost:8080
    @PostMapping
    public Mono<Map<String, Object>> pingServer(@RequestBody Map<String, Object> message) {
        return pingService.pingServer(message);
    }
}

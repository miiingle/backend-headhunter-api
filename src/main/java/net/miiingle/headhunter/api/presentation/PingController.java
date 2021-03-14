package net.miiingle.headhunter.api.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.miiingle.headhunter.api.core.PingService;
import net.miiingle.headhunter.api.core.RedisPing;
import net.miiingle.headhunter.api.repositories.PostgresPingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("ping")
@Slf4j
@RequiredArgsConstructor
// TODO: implement security
// https://medium.com/devops-dudes/securing-spring-boot-rest-apis-with-keycloak-1d760b2004e
// https://www.keycloak.org/getting-started/getting-started-docker
public class PingController {

    private final PingService pingService;

    //curl --header "X-Amzn-Trace-Id: Root=1-67891233-abcdef012345678912345678" --header "Content-Type: application/json" --request POST --data '{"ping":"pong"}' http://localhost:8080/ping/server
    //curl localhost:8080/ping/server
    @GetMapping("server")
    public Mono<Map<String, Object>> pingServer() {
        log.info("Ping Server");
        return pingService.pingServer();
    }

    //curl localhost:8080/ping/external
    @GetMapping("external")
    public Mono<String> pingOutside() {
        log.info("Ping External API");
        return pingService.pingOutsideWorld();
    }

    //curl localhost:8080/ping/postgres
    @GetMapping("postgres")
    public Mono<PostgresPingRepository.PostgresPing> pingPostgres() {
        log.info("Ping RDS");
        return pingService.pingPostgres();
    }

    //curl localhost:8080/ping/elasticsearch
    @GetMapping("elasticsearch")
    public Mono<Boolean> pingElasticsearch() {
        log.info("Ping ES");
        return pingService.pingElasticsearch();
    }

    //curl localhost:8080/ping/redis
    @GetMapping("redis")
    public Mono<RedisPing> pingRedis() {
        log.info("Ping Cache");
        return pingService.pingRedis();
    }
}

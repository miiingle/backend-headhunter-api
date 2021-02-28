package net.miiingle.headhunter.api.repositories;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PostgresPingRepository extends
        R2dbcRepository<PostgresPingRepository.PostgresPing,Long>,
        ReactiveCrudRepository<PostgresPingRepository.PostgresPing, Long> {

    @Data
    @Table
    class PostgresPing {

        @Id
        Long id;
        String name;
    }

    @Override
    @Query("SELECT :id as id, 'Test'||now() as name")
    Mono<PostgresPing> findById(Long id);
}



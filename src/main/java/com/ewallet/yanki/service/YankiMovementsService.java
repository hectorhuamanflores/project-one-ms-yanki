package com.ewallet.yanki.service;

import com.ewallet.yanki.entity.YankiMovements;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface YankiMovementsService {
    
	    public Flux<YankiMovements> getAllYankiMovements();
	    public Mono<YankiMovements> getYankiMovementsById(String id);
	    public Mono<YankiMovements> createYankiMovements(YankiMovements yankiMovements);
	    public Mono<YankiMovements> updateYankiMovements(YankiMovements yankiMovements);
	    public Mono<YankiMovements> deleteYankiMovements(String id);
	    public Flux<YankiMovements> getYankiMovementsByDocumentNumber(Integer numdoc);
}

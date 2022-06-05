package com.ewallet.yanki.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ewallet.yanki.entity.YankiMovements;

import reactor.core.publisher.Flux;

public interface YankiMovementsRepository extends ReactiveCrudRepository<YankiMovements,String>{
   
	Flux<YankiMovements> findByDocumentNumber(Integer documentNumber);
}

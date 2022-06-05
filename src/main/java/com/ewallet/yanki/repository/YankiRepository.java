package com.ewallet.yanki.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.ewallet.yanki.entity.Yanki;

import reactor.core.publisher.Flux;

@Repository
public interface YankiRepository  extends ReactiveCrudRepository<Yanki,String> {
    /*
     * find(loQuetrae)By(loQueBusca)
     * findByNombreContainingOrApellidoContaining(String nombre,String apellido);
     * 
     */
	Flux<Yanki> findByDocumentNumber(Integer documentNumber);
	
}

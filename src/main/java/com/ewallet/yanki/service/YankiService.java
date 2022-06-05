package com.ewallet.yanki.service;

import com.ewallet.yanki.dto.YankiRequest;
import com.ewallet.yanki.entity.Yanki;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface YankiService {

    public Flux<Yanki> getAllYanki();
    public Mono<Yanki> getYankiById(String id);
    public Mono<Yanki> createYanki(YankiRequest yankiRequest);
    public Mono<Yanki> updateYanki(YankiRequest yankiRequest);
    public Mono<Yanki> deleteYanki(String id);
    public Flux<Yanki> getYankiByDocumentNumber(Integer numdoc);
    
    
    

}

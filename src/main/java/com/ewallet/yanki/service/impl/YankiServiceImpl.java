package com.ewallet.yanki.service.impl;

import org.springframework.stereotype.Service;

import com.ewallet.yanki.dto.YankiRequest;
import com.ewallet.yanki.entity.Yanki;
import com.ewallet.yanki.repository.YankiRepository;
import com.ewallet.yanki.service.YankiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class YankiServiceImpl implements YankiService{
	private  final YankiRepository yankiRepository;

    @Override
    public Flux<Yanki> getAllYanki() {
        return yankiRepository.findAll();
    }

    @Override
    public Mono<Yanki> getYankiById(String id) {
        return yankiRepository.findById(id);
    }
    
    @Override
	public Flux<Yanki> getYankiByDocumentNumber(Integer numDoc) {
		return yankiRepository.findByDocumentNumber(numDoc);
	}
    
    @Override
    public Mono<Yanki> createYanki(YankiRequest yan) {
    	Double amount;
    	if(yan.getStatusAccount()) {
    		amount = -1.0;
    	}else {
    		amount = 0.0;
    	}
    	Yanki yanki = Yanki.builder()        
			         .mobile(yan.getMobile())     
			         .documentNumber(yan.getDocumentNumber())
			         .imei(yan.getImei())           
			         .email(yan.getEmail())         
			         .statusAccount(yan.getStatusAccount())  
			         .numberAccount(yan.getNumberAccount()) 
			         .balance(amount)
			         .dateStar(yan.getDateStar())
			         .build();
    	return yankiRepository.save(yanki);  
    }

    @Override
    public Mono<Yanki> updateYanki(YankiRequest yanki) {
    	
        
        return yankiRepository.findById(yanki.getId())
                .flatMap( object ->{
                	object.setMobile(yanki.getMobile());
                	object.setDocumentNumber(yanki.getDocumentNumber());
                	object.setImei(yanki.getImei());
                	object.setEmail(yanki.getEmail());
                	object.setStatusAccount(yanki.getStatusAccount());
                	object.setNumberAccount(yanki.getNumberAccount());
                	object.setDateStar(yanki.getDateStar());
                    return yankiRepository.save(object);
                 });
    }

    @Override
    public Mono<Yanki> deleteYanki(String id) {
        return yankiRepository.findById(id)
                .flatMap(existscreditRepository -> yankiRepository.delete(existscreditRepository)
                        .then(Mono.just(existscreditRepository)));
    }

	
}

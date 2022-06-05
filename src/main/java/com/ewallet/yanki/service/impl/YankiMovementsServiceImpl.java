package com.ewallet.yanki.service.impl;

import org.springframework.stereotype.Service;

import com.ewallet.yanki.entity.YankiMovements;
import com.ewallet.yanki.repository.YankiMovementsRepository;
import com.ewallet.yanki.service.YankiMovementsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class YankiMovementsServiceImpl implements YankiMovementsService{
	private  final YankiMovementsRepository yankiMovementsRepository;

    @Override
    public Flux<YankiMovements> getAllYankiMovements() {
        return yankiMovementsRepository.findAll();
    }

    @Override
    public Mono<YankiMovements> getYankiMovementsById(String id) {
        return yankiMovementsRepository.findById(id);
    }
    
    @Override
	public Flux<YankiMovements> getYankiMovementsByDocumentNumber(Integer numDoc) {
		return yankiMovementsRepository.findByDocumentNumber(numDoc);
	}
    
    @Override
    public Mono<YankiMovements> createYankiMovements(YankiMovements yan) {
    	return yankiMovementsRepository.save(yan);  
    }

    @Override
    public Mono<YankiMovements> updateYankiMovements(YankiMovements yanki) {
    	
        
        return yankiMovementsRepository.findById(yanki.getId())
                .flatMap( object ->{
                	object.setDocumentNumber(yanki.getDocumentNumber());
                	object.setStatus(yanki.getStatus());
                	object.setAmount(yanki.getAmount());
                	object.setDateStar(yanki.getDateStar());
                	object.setNameClient(yanki.getNameClient());
                    return yankiMovementsRepository.save(object);
                 });
    }

    @Override
    public Mono<YankiMovements> deleteYankiMovements(String id) {
        return yankiMovementsRepository.findById(id)
                .flatMap(existscreditRepository -> yankiMovementsRepository.delete(existscreditRepository)
                        .then(Mono.just(existscreditRepository)));
    }

	
}

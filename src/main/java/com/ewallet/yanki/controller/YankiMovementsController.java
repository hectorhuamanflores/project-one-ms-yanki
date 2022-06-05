package com.ewallet.yanki.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ewallet.yanki.dto.YankiByIdRequest;
import com.ewallet.yanki.dto.YankiByNumDocRequest;
import com.ewallet.yanki.dto.YankiRequest;
import com.ewallet.yanki.entity.Yanki;
import com.ewallet.yanki.entity.YankiMovements;
import com.ewallet.yanki.service.YankiMovementsService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/yankiMovements")
public class YankiMovementsController {
   
private final YankiMovementsService yankiMovementsService;
	
    @GetMapping
    public Flux<YankiMovements>getAllYanki() {
        Flux<YankiMovements> list=this.yankiMovementsService.getAllYankiMovements();
        return list; 
    }
    
    @PostMapping("/idYanki")
    public Mono<YankiMovements> getYankiById(@RequestBody YankiByIdRequest yankiByIdRequest){
        var Credit=this.yankiMovementsService.getYankiMovementsById(yankiByIdRequest.getIdYanki());
        return Credit;
    }
    
    @PostMapping("/numberDocument")
    public Flux<YankiMovements> getYankiByNumDoc(@RequestBody YankiByNumDocRequest yankiByNumDocRequest){
    	Flux<YankiMovements> list=this.yankiMovementsService.getYankiMovementsByDocumentNumber(yankiByNumDocRequest.getDocumentNumber());
        return  list;
    
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<YankiMovements> create(@RequestBody YankiMovements yanki){
        return yankiMovementsService.createYankiMovements(yanki);
    }

    @PutMapping("/updateYanki")
    public Mono<YankiMovements> updateYanki(@RequestBody YankiMovements yanki){
        return yankiMovementsService.updateYankiMovements(yanki);     
    }

    @DeleteMapping("/{id}")
    public Mono<YankiMovements> deleteYankiById(@PathVariable String id){
        return yankiMovementsService.deleteYankiMovements(id);
                
    }
	
}

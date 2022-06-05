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
import com.ewallet.yanki.service.YankiService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/yanki")
public class YankiController {

	private final YankiService yankiService;
	
    @GetMapping
    public Flux<Yanki>getAllYanki() {
        Flux<Yanki> list=this.yankiService.getAllYanki();
        return list; 
    }
    
    @PostMapping("/idYanki")
    public Mono<Yanki> getYankiById(@RequestBody YankiByIdRequest yankiByIdRequest){
        var Credit=this.yankiService.getYankiById(yankiByIdRequest.getIdYanki());
        return Credit;
    }
    
    @PostMapping("/numberDocument")
    public Flux<Yanki> getYankiByNumDoc(@RequestBody YankiByNumDocRequest yankiByNumDocRequest){
    	Flux<Yanki> list=this.yankiService.getYankiByDocumentNumber(yankiByNumDocRequest.getDocumentNumber());
        return  list;
    
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Yanki> create(@RequestBody YankiRequest Credit){
        return yankiService.createYanki(Credit);
    }

    @PutMapping("/updateYanki")
    public Mono<Yanki> updateYanki(@RequestBody YankiRequest Yanki){
        return this.yankiService.updateYanki(Yanki);         
    }

    @DeleteMapping("/{id}")
    public Mono<Yanki> deleteYankiById(@PathVariable String id){
        return yankiService.deleteYanki(id);
                
    }
    
   
    
}

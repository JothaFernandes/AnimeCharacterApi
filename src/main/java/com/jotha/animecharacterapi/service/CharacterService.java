package com.jotha.animecharacterapi.service;

import com.jotha.animecharacterapi.document.AnimeCharacter;
import com.jotha.animecharacterapi.repository.CharacterRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Flux<AnimeCharacter> findAll(){
        return Flux.fromIterable(this.characterRepository.findAll());
    }

    public Mono<AnimeCharacter> findByIdCharacter(String id){
        return Mono.justOrEmpty(this.characterRepository.findById(id));
    }

    public Mono<AnimeCharacter> save(AnimeCharacter animeCharacter){
        return Mono.justOrEmpty(this.characterRepository.save(animeCharacter));
    }

    public Mono<Boolean> deleteByIdCharacter(String id){
        characterRepository.deleteById(id);
        return Mono.just(true);
    }
}

package com.jotha.animecharacterapi.controller;

import com.jotha.animecharacterapi.document.AnimeCharacter;
import com.jotha.animecharacterapi.repository.CharacterRepository;
import com.jotha.animecharacterapi.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.jotha.animecharacterapi.constants.CharacterConstant.CHARACTER_ENDPOINT;

@RestController
public class CharacterController {

    private CharacterService characterService;

    private CharacterRepository characterRepository;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CharacterController.class);

    public CharacterController(CharacterService characterService, CharacterRepository characterRepository) {
        this.characterService = characterService;
        this.characterRepository = characterRepository;
    }

    @GetMapping(CHARACTER_ENDPOINT)
    @ResponseStatus(HttpStatus.OK)
    public Flux<AnimeCharacter> getAllItems() {
        log.info("Requesting the list off anime characters");
        return characterService.findAll();
    }

    @GetMapping(CHARACTER_ENDPOINT + "/{id}")
    public Mono<ResponseEntity<AnimeCharacter>> findByIdCharacter(@PathVariable String id){
        log.info("Requesting the anime character with id {}",id);
        return characterService.findByIdCharacter(id).map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(CHARACTER_ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AnimeCharacter> createCharacter(@RequestBody AnimeCharacter animeCharacter) {
        log.info("A new anime character was created");
        return characterService.save(animeCharacter);
    }

    @DeleteMapping(CHARACTER_ENDPOINT + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteByIdCharacter(@PathVariable String id) {
        characterService.deleteByIdCharacter(id);
        log.info("Deleting the anime character with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }

}

package com.jotha.animecharacterapi.repository;

import com.jotha.animecharacterapi.document.AnimeCharacter;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface CharacterRepository extends CrudRepository<AnimeCharacter, String> {

}

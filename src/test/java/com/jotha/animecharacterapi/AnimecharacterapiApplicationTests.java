package com.jotha.animecharacterapi;

import com.jotha.animecharacterapi.repository.CharacterRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.jotha.animecharacterapi.constants.CharacterConstant.CHARACTER_ENDPOINT;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class AnimecharacterapiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	CharacterRepository characterRepository;

	@Test
	public void getCharacterById(){

		webTestClient.get().uri(CHARACTER_ENDPOINT.concat("/{id}"),"2")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getCharacternotFound(){

		webTestClient.get().uri(CHARACTER_ENDPOINT.concat("/{id}"),"6")
				.exchange()
				.expectStatus().isNotFound();

	}


	@Test
	public void delete(){

		webTestClient.delete().uri(CHARACTER_ENDPOINT.concat("/{id}"),"5")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}

}

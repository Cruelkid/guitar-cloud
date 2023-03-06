package com.cruelkid.gcapiclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController
@RequestMapping("/api")
public class GuitarsController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/guitars")
    public List<String> getGuitars(
            @RegisteredOAuth2AuthorizedClient("guitar-cloud-client-authorization-code") OAuth2AuthorizedClient client
    ) {
        return webClient
                .get()
                .uri("http://127.0.0.1:8090/guitars")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>(){})
                .block();
    }

}

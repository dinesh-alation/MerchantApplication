package com.example.Merchant_UI.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class HttpUtils {

    @Autowired
    private WebClient webClient;



    public Object getAPICall(String url) {

        String str = webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return str;

    }

    public Object postAPICall(Object object, String url) {
        return webClient
                .post()
                .uri(url)
                .body(Mono.just(object), new ParameterizedTypeReference<Object>() {
                })
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}

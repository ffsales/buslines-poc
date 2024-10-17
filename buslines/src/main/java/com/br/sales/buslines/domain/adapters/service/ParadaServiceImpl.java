package com.br.sales.buslines.domain.adapters.service;

import com.br.sales.buslines.infrastructure.configuration.Commons;
import com.br.sales.buslines.domain.model.Credential;
import com.br.sales.buslines.domain.ports.ParadaService;
import com.br.sales.buslines.domain.ports.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

//@Service
public class ParadaServiceImpl implements ParadaService {

    private RestTemplate restTemplate;

    private TokenService tokenService;

    public ParadaServiceImpl(RestTemplate restTemplate, TokenService tokenService) {
        this.restTemplate = restTemplate;
        this.tokenService = tokenService;
    }

    @Override
    public String busca() {

        Credential credential = tokenService.getToken();

        String url = Commons.BASE_URL + "/Parada/Buscar?termosBusca=itaq";

        HttpHeaders headers = new HttpHeaders();
        headers.add("cookie", credential.getCredential());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            return restTemplate
                    .exchange(url, HttpMethod.GET, entity, String.class).getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }
}

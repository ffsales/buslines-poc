package com.br.sales.buslines.service;

import com.br.sales.buslines.Commons;
import com.br.sales.buslines.model.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ParadaServiceImpl implements ParadaService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TokenService tokenService;

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
            // Trate exceções se necessário
            e.printStackTrace();
            return null;
        }
    }
}

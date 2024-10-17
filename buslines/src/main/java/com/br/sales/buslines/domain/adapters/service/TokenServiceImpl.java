package com.br.sales.buslines.domain.adapters.service;

import com.br.sales.buslines.infrastructure.configuration.Commons;
import com.br.sales.buslines.domain.model.Credential;
import com.br.sales.buslines.domain.ports.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class TokenServiceImpl implements TokenService {

    private String token;

    private RestTemplate restTemplate;

    public TokenServiceImpl(RestTemplate restTemplate, String token) {
        this.restTemplate = restTemplate;
        this.token = token;
    }

    @Override
    public Credential getToken() {
        String url = Commons.BASE_URL + "/Login/Autenticar?token="+token;

        try {
            // Realiza a chamada POST
            ResponseEntity<String> response = restTemplate
                    .postForEntity(url, null, String.class);
//                    .exchange(url, HttpMethod.POST, null, String.class).getBody();

            Credential credential = new Credential();
            credential.setResult(response.getBody());
            credential.setCredential(response.getHeaders().get("Set-Cookie").get(0));

            return credential;
        } catch (RestClientException e) {
            // Trate exceções se necessário
            e.printStackTrace();
            return null;
        }
    }
}

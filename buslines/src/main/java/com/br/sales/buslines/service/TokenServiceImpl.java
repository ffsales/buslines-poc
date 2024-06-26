package com.br.sales.buslines.service;

import com.br.sales.buslines.Commons;
import com.br.sales.buslines.model.Credential;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    @Value("${token.sptrans}")
    private String token;

    @Autowired
    private RestTemplate restTemplate;

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

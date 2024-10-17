package com.br.sales.buslines.infrastructure.configuration;

import com.br.sales.buslines.domain.adapters.service.ParadaServiceImpl;
import com.br.sales.buslines.domain.adapters.service.TokenServiceImpl;
import com.br.sales.buslines.domain.ports.ParadaService;
import com.br.sales.buslines.domain.ports.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    TokenService tokenService(RestTemplate restTemplate, @Value("${token.sptrans}") String token) {
        return new TokenServiceImpl(restTemplate, token);
    }

    @Bean
    ParadaService paradaService(RestTemplate restTemplate, TokenService tokenService) {
        return new ParadaServiceImpl(restTemplate, tokenService);
    }
}

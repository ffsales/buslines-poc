package com.br.sales.buslines.domain.ports;

import com.br.sales.buslines.domain.model.Credential;

public interface TokenService {

    Credential getToken();
}

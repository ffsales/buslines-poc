package com.br.sales.buslines.application.adapter.controller;

import com.br.sales.buslines.domain.ports.ParadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parada")
public class ParadaController {

    private ParadaService paradaService;

    public ParadaController(ParadaService paradaService) {
        this.paradaService = paradaService;
    }

    @GetMapping
    @RequestMapping("busca")
    public String getParada() {

        return paradaService.busca();
    }
}

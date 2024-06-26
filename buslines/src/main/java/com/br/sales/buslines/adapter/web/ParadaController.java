package com.br.sales.buslines.adapter.web;

import com.br.sales.buslines.service.ParadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parada")
public class ParadaController {

    @Autowired
    private ParadaService paradaService;

    @GetMapping
    @RequestMapping("busca")
    public String getParada() {

        return paradaService.busca();
    }
}

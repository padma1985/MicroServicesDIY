package org.example.microservices.currencyexchange.controller;

import org.example.microservices.currencyexchange.dto.CurrencyExchangeDTO;
import org.example.microservices.currencyexchange.model.CurrencyExchange;
import org.example.microservices.currencyexchange.service.CurrencyExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final CurrencyExchangeService  currencyExchangeService;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping(path="/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeDTO getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
       return this.currencyExchangeService.getCurrencyExchangeValue(from, to);
    }
}

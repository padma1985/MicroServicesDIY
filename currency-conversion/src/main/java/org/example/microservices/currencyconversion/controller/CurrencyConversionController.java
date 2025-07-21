package org.example.microservices.currencyconversion.controller;

import org.example.microservices.currencyconversion.dto.CurrencyConversionDTO;
import org.example.microservices.currencyconversion.service.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    public CurrencyConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping(path="/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversionDTO> getCurrencyConversion(@PathVariable String from,
                                                                       @PathVariable String to,
                                                                       @PathVariable long quantity) {
        return ResponseEntity.ok(this.currencyConversionService.getCurrencyConversion(from, to, quantity));
    }
}

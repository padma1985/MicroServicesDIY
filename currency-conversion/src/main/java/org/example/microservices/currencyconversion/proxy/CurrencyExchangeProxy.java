package org.example.microservices.currencyconversion.proxy;

import org.example.microservices.currencyconversion.dto.CurrencyConversionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionDTO getCurrencyExchange(@PathVariable String from, @PathVariable String to);
}

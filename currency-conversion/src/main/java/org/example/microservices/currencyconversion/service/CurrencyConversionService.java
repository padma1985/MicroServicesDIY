package org.example.microservices.currencyconversion.service;

import org.example.microservices.currencyconversion.CurrencyConversionApplication;
import org.example.microservices.currencyconversion.dto.CurrencyConversionDTO;
import org.example.microservices.currencyconversion.proxy.CurrencyExchangeProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionService {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversionService(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    public CurrencyConversionDTO getCurrencyConversion(String from, String to, long quantity) {
        CurrencyConversionDTO currencyConversionDTO = this.currencyExchangeProxy.getCurrencyExchange(from, to);
        CurrencyConversionDTO responseDTO = new CurrencyConversionDTO();
        responseDTO.setFrom(currencyConversionDTO.getFrom());
        responseDTO.setTo(currencyConversionDTO.getTo());
        responseDTO.setId(currencyConversionDTO.getId());
        responseDTO.setQuantity(quantity);
        responseDTO.setExchangeValue(currencyConversionDTO.getExchangeValue());
        responseDTO.setRate(currencyConversionDTO.getExchangeValue().multiply(BigDecimal.valueOf(quantity)));
        responseDTO.setPort(currencyConversionDTO.getPort());
        return responseDTO;
    }
}

package org.example.microservices.currencyexchange.service;

import org.example.microservices.currencyexchange.dto.CurrencyExchangeDTO;
import org.example.microservices.currencyexchange.model.CurrencyExchange;
import org.example.microservices.currencyexchange.repo.CurrencyExchangeRepo;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    private final CurrencyExchangeRepo currencyExchangeRepo;

    private final Environment environment;

    public CurrencyExchangeService(CurrencyExchangeRepo currencyExchangeRepo, Environment environment) {
        this.currencyExchangeRepo = currencyExchangeRepo;
        this.environment = environment;
    }

    public CurrencyExchangeDTO getCurrencyExchangeValue(String from, String to) {
        CurrencyExchange currencyExchange = this.currencyExchangeRepo.findCurrencyExchangeByFromAndTo(from, to);
        CurrencyExchangeDTO currencyExchangeDTO = new CurrencyExchangeDTO();
        currencyExchangeDTO.setId(currencyExchange.getId());
        currencyExchangeDTO.setFrom(currencyExchange.getFrom());
        currencyExchangeDTO.setTo(currencyExchange.getTo());
        currencyExchangeDTO.setExchangeValue(currencyExchange.getExchangeValue());
        currencyExchangeDTO.setPort(this.environment.getProperty("local.server.port"));
        return currencyExchangeDTO;
    }
}

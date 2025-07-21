package org.example.microservices.currencyexchange.repo;

import org.example.microservices.currencyexchange.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, UUID> {
    public CurrencyExchange findCurrencyExchangeByFromAndTo(String from, String to);
}

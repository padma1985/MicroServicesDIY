package org.example.microservices.currencyexchange.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CurrencyExchangeDTO {
    private UUID id;

    private String from;

    private String to;

    private BigDecimal exchangeValue;

    private String port;
}


package org.example.microservices.currencyconversion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CurrencyConversionDTO {
    private UUID id;
    private String from;
    private String to;
    private long quantity;
    private BigDecimal exchangeValue;
    private BigDecimal rate;
    private String port;
}

package com.anz.wholesale.account.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class AccountDto {
    private Long accountNumber;
    private String accountName;
    private String accountType;
    private Instant balanceDate;
    private String currency;
    private BigDecimal openingAvlBalance;
}

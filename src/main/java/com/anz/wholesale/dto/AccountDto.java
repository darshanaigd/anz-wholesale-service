package com.anz.wholesale.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class AccountDto {
    private Long accountNumber;
    private String accountName;
    private String accountType;
    private Date balanceDate;
    private String currency;
    private BigDecimal openingAvlBalance;
}

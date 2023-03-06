package com.anz.wholesale.transaction.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class TransactionDto {
    private Long accountNumber;
    private String accountName;
    private Instant valueDate;
    private String currency;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String drCrIndicator;
    private String transactionNarrative;

}

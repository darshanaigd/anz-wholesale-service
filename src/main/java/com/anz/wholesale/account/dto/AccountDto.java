package com.anz.wholesale.account.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class AccountDto extends RepresentationModel<AccountDto> {
    private Long accountNumber;
    private String accountName;
    private String accountType;
    private Instant balanceDate;
    private String currency;
    private BigDecimal openingAvlBalance;
}

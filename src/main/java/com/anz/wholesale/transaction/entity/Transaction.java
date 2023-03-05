package com.anz.wholesale.transaction.entity;

import com.anz.wholesale.account.enitity.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "value_date")
    private Instant valueDate;

    @Column(name = "currency")
    private String currency;

    @Column(name = "debit_amount")
    private BigDecimal debitAmount;

    @Column(name = "credit_amount")
    private BigDecimal creditAmount;

    @Column(name = "dr_cr_indicator")
    private String drCrIndicator;

    @Column(name = "transaction_narrative")
    private String transactionNarrative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number")
    private Account account;

}

package com.anz.wholesale.account.enitity;

import com.anz.wholesale.customer.entity.Customer;
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
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "account_number_seq_gen")
    @SequenceGenerator(name = "account_number_seq_gen", sequenceName = "account_number_seq", allocationSize = 1)
    private Long accountNumber;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "balance_date")
    private Instant balanceDate;

    @Column(name = "currency")
    private String currency;

    @Column(name = "opening_avl_balance")
    private BigDecimal openingAvlBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

package com.anz.wholesale.repository;

import com.anz.wholesale.entity.Account;
import com.anz.wholesale.entity.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TransactionRepositoryTest {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findAllByAccount_withValidAccount() {
        accountRepository.findById(1234596799L).ifPresentOrElse(account -> {
            List<Transaction> transactionList = transactionRepository.findAllByAccount(account, PageRequest.of(0, 100))
                    .getContent();
            assertThat(transactionList).isNotNull();
            assertThat(transactionList.size()).isEqualTo(12);
        }, () -> {
            fail("Account is not present");
        });


    }

    @Test
    public void findAllByAccount_withInValidAccount() {
        List<Transaction> transactionList = transactionRepository.findAllByAccount(Account.builder()
                .accountNumber(1L)
                .accountName("xxxxx")
                .build(), PageRequest.of(0, 100)).getContent();

        assertThat(transactionList).isNotNull();
        assertThat(transactionList.size()).isEqualTo(0);
    }
}

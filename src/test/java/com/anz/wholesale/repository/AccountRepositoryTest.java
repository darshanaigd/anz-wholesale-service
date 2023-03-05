package com.anz.wholesale.repository;

import com.anz.wholesale.entity.Account;
import com.anz.wholesale.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findAllByCustomer_withValidCustomer() {
        List<Account> accountList = accountRepository.findAllByCustomer(Customer.builder()
                .customerId(1001L)
                .firstName("Kiyaan")
                .lastName("Seth").build());

        assertThat(accountList).isNotNull();
        assertThat(accountList.size()).isEqualTo(11);
    }

    @Test
    public void findAllByCustomer_withInValidCustomer() {
        List<Account> accountList = accountRepository.findAllByCustomer(Customer.builder()
                .customerId(-1L)
                .firstName("xxx")
                .lastName("xxx").build());

        assertThat(accountList).isNotNull();
        assertThat(accountList.size()).isEqualTo(0);
    }
}

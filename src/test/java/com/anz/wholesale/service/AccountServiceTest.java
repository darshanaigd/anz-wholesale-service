package com.anz.wholesale.service;


import com.anz.wholesale.account.dto.AccountDto;
import com.anz.wholesale.account.enitity.Account;
import com.anz.wholesale.account.mapper.AccountMapper;
import com.anz.wholesale.account.repository.AccountRepository;
import com.anz.wholesale.account.service.AccountService;
import com.anz.wholesale.common.exception.AccountClientException;
import com.anz.wholesale.customer.entity.Customer;
import com.anz.wholesale.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private AccountMapper accountMapper;
    @Mock
    private AccountRepository accountRepository;

    @Test
    public void getAccountsByCustomerId_success() {
        //When
        when(customerRepository.findById(any())).thenReturn(Optional.of(new Customer()));
        when(accountMapper.accountToAccountDto(any())).thenReturn(List.of(AccountDto.builder().build()));
        when(accountRepository.findAllByCustomer(any())).thenReturn(List.of(Account.builder().build()));

        List<AccountDto> accountDtoList = assertDoesNotThrow(() -> accountService.getAccountsByCustomerId(100L));
        assertThat(accountDtoList).isNotNull();

    }

    @Test
    public void getAccountsByCustomerId_throwException() {
        //When
        when(customerRepository.findById(any())).thenReturn(Optional.empty());

        AccountClientException exception = assertThrows(AccountClientException.class,
                () -> accountService.getAccountsByCustomerId(100L));
        assertThat(exception.getErrorId()).isEqualTo("E001");

    }

}

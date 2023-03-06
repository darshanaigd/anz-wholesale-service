package com.anz.wholesale.service;


import com.anz.wholesale.account.enitity.Account;
import com.anz.wholesale.account.repository.AccountRepository;
import com.anz.wholesale.common.exception.AccountClientException;
import com.anz.wholesale.customer.entity.Customer;
import com.anz.wholesale.transaction.dto.ResponseTransactionList;
import com.anz.wholesale.transaction.dto.TransactionDto;
import com.anz.wholesale.transaction.entity.Transaction;
import com.anz.wholesale.transaction.mapper.TransactionMapper;
import com.anz.wholesale.transaction.repository.TransactionRepository;
import com.anz.wholesale.transaction.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;
    @Mock
    private TransactionMapper transactionMapper;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TransactionRepository transactionRepository;

    @Test
    public void getTransactionByAccountId_success() {
        //When
        Page<Transaction> pageable = Mockito.mock(Page.class);
        when(transactionMapper.transactionToTransactionDto(any())).thenReturn(TransactionDto.builder().build());
        when(accountRepository.findById(any())).thenReturn(Optional.of(Account.builder()
                .customer(Customer.builder().customerId(11L).build()).build()));
        when(transactionRepository.findAllByAccount(any(), any())).thenReturn(pageable);
        when(pageable.getContent()).thenReturn(List.of(Transaction.builder().build()));

        ResponseTransactionList responseTransactionList = assertDoesNotThrow(() -> transactionService.getTransactionByAccountId(100L, 1, 1));
        assertThat(responseTransactionList).isNotNull();

    }

    @Test
    public void getTransactionByAccountId_throwException() {
        //When
        when(accountRepository.findById(any())).thenReturn(Optional.empty());

        AccountClientException exception = assertThrows(AccountClientException.class,
                () -> transactionService.getTransactionByAccountId(100L, 1, 1));
        assertThat(exception.getErrorId()).isEqualTo("E002");
    }

}

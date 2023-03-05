package com.anz.wholesale.service;

import com.anz.wholesale.dto.ResponseTransactionList;
import com.anz.wholesale.entity.Account;
import com.anz.wholesale.entity.Transaction;
import com.anz.wholesale.exception.AccountClientException;
import com.anz.wholesale.exception.ApiError;
import com.anz.wholesale.mapper.TransactionMapper;
import com.anz.wholesale.repository.AccountRepository;
import com.anz.wholesale.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TransactionService {
    public static final String E002 = "E002";
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TransactionMapper transactionMapper;
    private final MessageSource messageSource;

    public ResponseTransactionList getTransactionByAccountId(Long accountId, int page, int size) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            Page<Transaction> transactionPage = transactionRepository.findAllByAccount(optionalAccount.get(), PageRequest.of(page, size));
            return transactionMapper.ToResponseTransactionList(transactionPage.getContent(),
                    transactionPage.getTotalPages(), transactionPage.getTotalElements());
        } else {
            throw new AccountClientException(HttpStatus.BAD_REQUEST, E002);
        }
    }

}


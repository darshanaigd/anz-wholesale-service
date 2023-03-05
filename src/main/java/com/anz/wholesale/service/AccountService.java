package com.anz.wholesale.service;

import com.anz.wholesale.dto.AccountDto;
import com.anz.wholesale.entity.Customer;
import com.anz.wholesale.exception.AccountClientException;
import com.anz.wholesale.exception.ApiError;
import com.anz.wholesale.mapper.AccountMapper;
import com.anz.wholesale.repository.AccountRepository;
import com.anz.wholesale.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {
    public static final String E001 = "E001";
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountMapper accountMapper;

    public List<AccountDto> getAccountsByCustomerId(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            return accountMapper.accountToAccountDto(accountRepository.findAllByCustomer(customerOptional.get()));
        } else {
            throw new AccountClientException(HttpStatus.BAD_REQUEST, E001);
        }
    }

}

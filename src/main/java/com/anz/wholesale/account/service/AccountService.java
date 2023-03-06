package com.anz.wholesale.account.service;

import com.anz.wholesale.account.dto.AccountDto;
import com.anz.wholesale.account.mapper.AccountMapper;
import com.anz.wholesale.account.repository.AccountRepository;
import com.anz.wholesale.common.exception.AccountClientException;
import com.anz.wholesale.customer.entity.Customer;
import com.anz.wholesale.customer.repository.CustomerRepository;
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

package com.anz.wholesale.account.controller;

import com.anz.wholesale.account.dto.AccountDto;
import com.anz.wholesale.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{customerId}")
    List<AccountDto> getAccountsByCustomerId(@PathVariable Long customerId) {
        return accountService.getAccountsByCustomerId(customerId);
    }

}

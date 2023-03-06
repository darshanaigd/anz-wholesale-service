package com.anz.wholesale.transaction.controller;

import com.anz.wholesale.transaction.dto.ResponseTransactionList;
import com.anz.wholesale.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
@Slf4j
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/{accountId}/transactions")
    public ResponseTransactionList getTransactionByAccountId(@PathVariable Long accountId,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "100") int size) {
        log.info("Get transactions for account={} page={} size={}", accountId, page, size);
        return transactionService.getTransactionByAccountId(accountId, page, size);
    }

}


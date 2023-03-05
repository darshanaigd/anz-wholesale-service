package com.anz.wholesale.transaction.controller;

import com.anz.wholesale.transaction.dto.ResponseTransactionList;
import com.anz.wholesale.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/{accountId}/transactions")
    ResponseTransactionList getTransactionByAccountId(@PathVariable Long accountId,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "100") int size) {
        return transactionService.getTransactionByAccountId(accountId, page, size);
    }

}


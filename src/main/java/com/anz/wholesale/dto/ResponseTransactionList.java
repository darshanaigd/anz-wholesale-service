package com.anz.wholesale.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseTransactionList {
    private int totalPages;
    private long totalElements;
    private List<TransactionDto> transactions;
}
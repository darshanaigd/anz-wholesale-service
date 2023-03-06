package com.anz.wholesale.transaction.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ResponseTransactionList extends RepresentationModel<ResponseTransactionList> {
    private int totalPages;
    private long totalElements;
    private List<TransactionDto> transactions;
}
package com.anz.wholesale.transaction.mapper;

import com.anz.wholesale.transaction.dto.ResponseTransactionList;
import com.anz.wholesale.transaction.dto.TransactionDto;
import com.anz.wholesale.transaction.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {
    TransactionDto transactionToTransactionDto(Transaction transaction);

    ResponseTransactionList ToResponseTransactionList(List<Transaction> transactions, int totalPages, long totalElements);
}

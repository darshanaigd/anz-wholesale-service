package com.anz.wholesale.mapper;

import com.anz.wholesale.dto.ResponseTransactionList;
import com.anz.wholesale.dto.TransactionDto;
import com.anz.wholesale.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {
    TransactionDto transactionToTransactionDto(Transaction transaction);

    ResponseTransactionList ToResponseTransactionList(List<Transaction> transactions, int totalPages, long totalElements);
}

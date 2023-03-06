package com.anz.wholesale.transaction.mapper;

import com.anz.wholesale.transaction.dto.TransactionDto;
import com.anz.wholesale.transaction.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {
    @Mapping(target = "accountNumber", source = "transaction.account.accountNumber")
    @Mapping(target = "accountName", source = "transaction.account.accountName")
    TransactionDto transactionToTransactionDto(Transaction transaction);

}

package com.anz.wholesale.account.mapper;

import com.anz.wholesale.account.dto.AccountDto;
import com.anz.wholesale.account.enitity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {
    List<AccountDto> accountToAccountDto(List<Account> accountList);
}

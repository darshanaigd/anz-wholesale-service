package com.anz.wholesale.mapper;

import com.anz.wholesale.dto.AccountDto;
import com.anz.wholesale.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {
    List<AccountDto> accountToAccountDto(List<Account> accountList);
}

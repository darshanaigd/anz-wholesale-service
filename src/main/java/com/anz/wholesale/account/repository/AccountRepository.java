package com.anz.wholesale.account.repository;

import com.anz.wholesale.account.enitity.Account;
import com.anz.wholesale.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByCustomer(Customer customer);
}

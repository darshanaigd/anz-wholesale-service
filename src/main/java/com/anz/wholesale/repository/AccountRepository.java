package com.anz.wholesale.repository;

import com.anz.wholesale.entity.Account;
import com.anz.wholesale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByCustomer(Customer customer);
}

package com.anz.wholesale.repository;

import com.anz.wholesale.entity.Account;
import com.anz.wholesale.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findAllByAccount(Account account, Pageable pageable);
}

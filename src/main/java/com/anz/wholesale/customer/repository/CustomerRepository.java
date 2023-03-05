package com.anz.wholesale.customer.repository;

import com.anz.wholesale.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

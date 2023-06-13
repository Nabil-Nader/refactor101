package com.refactor.code.dry.principle.repository;

import com.refactor.code.dry.principle.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

package com.customer.categorizer.application.database.sqlite.customer;

import com.customer.categorizer.application.database.sqlite.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity,Long> {
}

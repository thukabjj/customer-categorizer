package com.customer.categorizer.usecase.gateway.repository;

import com.customer.categorizer.domain.customer.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
}

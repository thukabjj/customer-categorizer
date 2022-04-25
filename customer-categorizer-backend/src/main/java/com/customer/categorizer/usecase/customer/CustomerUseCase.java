package com.customer.categorizer.usecase.customer;

import com.customer.categorizer.domain.customer.Customer;

import java.util.List;

public interface CustomerUseCase {

    List<Customer> getCustomers();
}

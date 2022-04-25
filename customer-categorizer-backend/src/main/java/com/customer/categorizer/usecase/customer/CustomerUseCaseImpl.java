package com.customer.categorizer.usecase.customer;

import com.customer.categorizer.domain.customer.Customer;
import com.customer.categorizer.usecase.gateway.repository.CustomerRepository;

import java.util.List;

public class CustomerUseCaseImpl implements CustomerUseCase {

    private final CustomerRepository customerRepository;

    public CustomerUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getAllCustomers();
    }

}

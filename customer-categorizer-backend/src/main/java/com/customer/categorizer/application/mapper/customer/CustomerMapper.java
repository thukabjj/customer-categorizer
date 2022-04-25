package com.customer.categorizer.application.mapper.customer;

import com.customer.categorizer.application.entrypoint.customer.entity.CustomerEntrypointResponse;
import com.customer.categorizer.domain.customer.Customer;

import java.util.List;

public interface CustomerMapper {
    List<CustomerEntrypointResponse> fromCustomerDomainToCustomerEntrypointResponse(List<Customer> customersDomain);
}

package com.customer.categorizer.application.mapper.customer;

import com.customer.categorizer.application.entrypoint.customer.entity.CustomerEntrypointResponse;
import com.customer.categorizer.domain.customer.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public List<CustomerEntrypointResponse> fromCustomerDomainToCustomerEntrypointResponse(List<Customer> customersDomain) {
        return customersDomain
                .stream()
                .map(c -> new CustomerEntrypointResponse(c.getId(), c.getName(), c.getCountry().getCountryName(), c.getPhone(), c.getState().getStateName()))
                .collect(Collectors.toList());
    }

}

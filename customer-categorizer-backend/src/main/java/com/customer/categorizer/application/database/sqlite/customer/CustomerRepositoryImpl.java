package com.customer.categorizer.application.database.sqlite.customer;

import com.customer.categorizer.application.database.sqlite.customer.entity.CustomerEntity;
import com.customer.categorizer.domain.customer.Customer;
import com.customer.categorizer.usecase.gateway.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private CustomerDAO localeDAO;

    @Override
    public List<Customer> getAllCustomers() {
        final List<CustomerEntity> customersEntity = localeDAO.findAll();
        final List<Customer> customers = customersEntity
                .stream()
                .map(customerEntity -> new Customer(customerEntity.getId(), customerEntity.getName(), customerEntity.getPhone()))
                .collect(Collectors.toList());
        return customers;
    }

}

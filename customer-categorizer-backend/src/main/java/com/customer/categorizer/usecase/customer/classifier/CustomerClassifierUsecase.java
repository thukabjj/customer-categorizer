package com.customer.categorizer.usecase.customer.classifier;

import com.customer.categorizer.domain.customer.Customer;

import java.util.List;

public interface CustomerClassifierUsecase {
    List<Customer> getCustomerClassified();
}

package com.customer.categorizer.infrastructure.spring;

import com.customer.categorizer.application.mapper.customer.CustomerMapper;
import com.customer.categorizer.application.mapper.customer.CustomerMapperImpl;
import com.customer.categorizer.usecase.customer.CustomerUseCase;
import com.customer.categorizer.usecase.customer.CustomerUseCaseImpl;
import com.customer.categorizer.usecase.customer.classifier.CustomerClassifierUsecase;
import com.customer.categorizer.usecase.customer.classifier.CustomerClassifierUsecaseImpl;
import com.customer.categorizer.usecase.gateway.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CustomerClassifierUsecase injectCustomerClassifierUsecase(final CustomerUseCase customerUseCase) {
        return new CustomerClassifierUsecaseImpl(customerUseCase);
    }

    @Bean
    public CustomerUseCase injectCustomerUseCase(final CustomerRepository customerRepository) {
        return new CustomerUseCaseImpl(customerRepository);
    }

    @Bean
    public CustomerMapper injectCustomerMapper() {
        return new CustomerMapperImpl();
    }

}

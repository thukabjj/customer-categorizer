package com.customer.categorizer.usecase.customer;

import com.customer.categorizer.domain.customer.Customer;
import com.customer.categorizer.usecase.gateway.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerUseCaseImplTest {

    @InjectMocks
    private CustomerUseCaseImpl customerUseCase;

    @Mock
    private CustomerRepository customerRepository;

    @DisplayName("Test - Should return a list of customers")
    @Test
    public void should_return_a_list_of_customers() {

        //given
        final List<Customer> expected = List.of(
                new Customer(1L, "test 1", "(212) 6007989253"),
                new Customer(2L, "test 2", "(258) 847651504"),
                new Customer(3L, "test 3", "(251) 966002259")
        );

        //when
        when(customerRepository.getAllCustomers()).thenReturn(expected);

        //then
        final List<Customer> response = customerUseCase.getCustomers();

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);

    }

}
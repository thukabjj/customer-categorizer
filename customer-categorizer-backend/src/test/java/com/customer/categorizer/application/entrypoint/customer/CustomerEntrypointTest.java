package com.customer.categorizer.application.entrypoint.customer;

import com.customer.categorizer.application.entrypoint.customer.entity.CustomerEntrypointResponse;
import com.customer.categorizer.application.mapper.customer.CustomerMapper;
import com.customer.categorizer.domain.customer.Country;
import com.customer.categorizer.domain.customer.Customer;
import com.customer.categorizer.usecase.customer.classifier.CustomerClassifierUsecase;
import com.customer.categorizer.domain.customer.State;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerEntrypointTest {

    @Mock
    private CustomerClassifierUsecase customerClassifierUsecase;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerEntrypoint customerEntrypoint;

    @Test
    public void should_return_a_list_of_customers_categorized_by_country() {
        //given
        final List<Customer> customers = List.of(
                new Customer(1L, "test 1", Country.CAMEROON, "(237) 697151594", State.VALID),
                new Customer(2L, "test 2", Country.CAMEROON, "(237) 6780009592", State.NOT_VALID),
                new Customer(3L, "test 3", Country.ETHIOPIA, "(251) 914701723", State.VALID),
                new Customer(4L, "test 4,", Country.ETHIOPIA, "(251) 9773199405", State.NOT_VALID),
                new Customer(5L, "test 5", Country.MOROCCO, "(212) 698054317", State.VALID),
                new Customer(6L, "test 6", Country.MOROCCO, "(212) 6546545369", State.NOT_VALID),
                new Customer(7L, "test 7", Country.MOZAMBIQUE, "(258) 846565883", State.VALID),
                new Customer(8L, "test 8", Country.MOZAMBIQUE, "(258) 84330678235", State.NOT_VALID),
                new Customer(9L, "test 9", Country.UGANDA, "(256) 704244430", State.VALID),
                new Customer(10L, "test 10", Country.UGANDA, "(256) 7503O6263", State.NOT_VALID)
        );
        final List<CustomerEntrypointResponse> expected = List.of(
                new CustomerEntrypointResponse(1L, "test 1", Country.CAMEROON.getCountryName(), "(237) 697151594", State.VALID.getStateName()),
                new CustomerEntrypointResponse(2L, "test 2", Country.CAMEROON.getCountryName(), "(237) 6780009592", State.NOT_VALID.getStateName()),
                new CustomerEntrypointResponse(3L, "test 3", Country.ETHIOPIA.getCountryName(), "(251) 914701723", State.VALID.getStateName()),
                new CustomerEntrypointResponse(4L, "test 4,", Country.ETHIOPIA.getCountryName(), "(251) 9773199405", State.NOT_VALID.getStateName()),
                new CustomerEntrypointResponse(5L, "test 5", Country.MOROCCO.getCountryName(), "(212) 698054317", State.VALID.getStateName()),
                new CustomerEntrypointResponse(6L, "test 6", Country.MOROCCO.getCountryName(), "(212) 6546545369", State.NOT_VALID.getStateName()),
                new CustomerEntrypointResponse(7L, "test 7", Country.MOZAMBIQUE.getCountryName(), "(258) 846565883", State.VALID.getStateName()),
                new CustomerEntrypointResponse(8L, "test 8", Country.MOZAMBIQUE.getCountryName(), "(258) 84330678235", State.NOT_VALID.getStateName()),
                new CustomerEntrypointResponse(9L, "test 9", Country.UGANDA.getCountryName(), "(256) 704244430", State.VALID.getStateName()),
                new CustomerEntrypointResponse(10L, "test 10", Country.UGANDA.getCountryName(), "(256) 7503O6263", State.NOT_VALID.getStateName())
        );

        //when

        when(customerClassifierUsecase.getCustomerClassified()).thenReturn(customers);
        when(customerMapper.fromCustomerDomainToCustomerEntrypointResponse(any())).thenReturn(expected);

        //then
        final ResponseEntity<List<CustomerEntrypointResponse>> response = customerEntrypoint.getCustomersClassifiedByCountry();

        Assertions.assertThat(response.getBody()).usingRecursiveComparison()
                .isEqualTo(expected);
    }

}
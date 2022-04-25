package com.customer.categorizer.usecase.customer.classifier;

import com.customer.categorizer.domain.customer.Country;
import com.customer.categorizer.domain.customer.Customer;
import com.customer.categorizer.domain.customer.State;
import com.customer.categorizer.usecase.customer.CustomerUseCase;
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
public class CustomerClassifierUsecaseImplTest {

    @Mock
    private CustomerUseCase customerUseCase;

    @InjectMocks
    private CustomerClassifierUsecaseImpl customerClassifierUsecaseImpl;

    @DisplayName("Test - Should return a list of customers of Cameroon classified")
    @Test
    public void should_return_list_of_customers_from_cameroon_classified() {

        //given
        final List<Customer> customers = List.of(
                new Customer(1L, "test 1", "(237) 697151594"),
                new Customer(2L, "test 2", "(237) 677046616"),
                new Customer(3L, "test 3", "(237) 6A0311634"),
                new Customer(4L, "test 4", "(237) 6780009592")
        );

        final List<Customer> expected = List.of(
                new Customer(1L, "test 1", Country.CAMEROON, "(237) 697151594", State.VALID),
                new Customer(2L, "test 2", Country.CAMEROON, "(237) 677046616", State.VALID),
                new Customer(3L, "test 3", Country.CAMEROON, "(237) 6A0311634", State.NOT_VALID),
                new Customer(4L, "test 4", Country.CAMEROON, "(237) 6780009592", State.NOT_VALID)
        );

        //when
        when(customerUseCase.getCustomers()).thenReturn(customers);

        //then
        final List<Customer> response = customerClassifierUsecaseImpl.getCustomerClassified();

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);

    }

    @DisplayName("Test - Should return a list of customers of Ethiopia classified")
    @Test
    public void should_return_list_of_customers_from_ethiopia_classified() {

        //given
        final List<Customer> customers = List.of(
                new Customer(1L, "test 1", "(251) 914701723"),
                new Customer(2L, "test 2", "(251) 911203317"),
                new Customer(3L, "test 3", "(251) 9773199405"),
                new Customer(4L, "test 4", "(251) 9119454961")
        );

        final List<Customer> expected = List.of(
                new Customer(1L, "test 1", Country.ETHIOPIA, "(251) 914701723", State.VALID),
                new Customer(2L, "test 2", Country.ETHIOPIA, "(251) 911203317", State.VALID),
                new Customer(3L, "test 3", Country.ETHIOPIA, "(251) 9773199405", State.NOT_VALID),
                new Customer(4L, "test 4", Country.ETHIOPIA, "(251) 9119454961", State.NOT_VALID)
        );

        //when
        when(customerUseCase.getCustomers()).thenReturn(customers);

        //then
        final List<Customer> response = customerClassifierUsecaseImpl.getCustomerClassified();

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);

    }

    @DisplayName("Test - Should return a list of customers of Morocco classified")
    @Test
    public void should_return_list_of_customers_from_morocco_classified() {

        //given
        final List<Customer> customers = List.of(
                new Customer(1L, "test 1", "(212) 698054317"),
                new Customer(2L, "test 2", "(212) 691933626"),
                new Customer(3L, "test 3", "(212) 6546545369"),
                new Customer(4L, "test 4", "(212) 6007989253")
        );

        final List<Customer> expected = List.of(
                new Customer(1L, "test 1", Country.MOROCCO, "(212) 698054317", State.VALID),
                new Customer(2L, "test 2", Country.MOROCCO, "(212) 691933626", State.VALID),
                new Customer(3L, "test 3", Country.MOROCCO, "(212) 6546545369", State.NOT_VALID),
                new Customer(4L, "test 4", Country.MOROCCO, "(212) 6007989253", State.NOT_VALID)
        );

        //when
        when(customerUseCase.getCustomers()).thenReturn(customers);

        //then
        final List<Customer> response = customerClassifierUsecaseImpl.getCustomerClassified();

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);

    }

    @DisplayName("Test - Should return a list of customers of Mozambique classified")
    @Test
    public void should_return_list_of_customers_from_mozambique_classified() {

        //given
        final List<Customer> customers = List.of(
                new Customer(1L, "test 1", "(258) 847651504"),
                new Customer(2L, "test 2", "(258) 846565883"),
                new Customer(3L, "test 3", "(258) 84330678235"),
                new Customer(4L, "test 4", "(258) 042423566")
        );

        final List<Customer> expected = List.of(
                new Customer(1L, "test 1", Country.MOZAMBIQUE, "(258) 847651504", State.VALID),
                new Customer(2L, "test 2", Country.MOZAMBIQUE, "(258) 846565883", State.VALID),
                new Customer(3L, "test 3", Country.MOZAMBIQUE, "(258) 84330678235", State.NOT_VALID),
                new Customer(4L, "test 4", Country.MOZAMBIQUE, "(258) 042423566", State.NOT_VALID)
        );

        //when
        when(customerUseCase.getCustomers()).thenReturn(customers);

        //then
        final List<Customer> response = customerClassifierUsecaseImpl.getCustomerClassified();

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);

    }


    @DisplayName("Test - Should return a list of customers of Uganda classified")
    @Test
    public void should_return_list_of_customers_from_uganda_classified() {

        //given
        final List<Customer> customers = List.of(
                new Customer(1L, "test 1", "(256) 775069443"),
                new Customer(2L, "test 2", "(256) 704244430"),
                new Customer(3L, "test 3", "(256) 7503O6263"),
                new Customer(4L, "test 4", "(256) 7734127498")
        );

        final List<Customer> expected = List.of(
                new Customer(1L, "test 1", Country.UGANDA, "(256) 775069443", State.VALID),
                new Customer(2L, "test 2", Country.UGANDA, "(256) 704244430", State.VALID),
                new Customer(3L, "test 3", Country.UGANDA, "(256) 7503O6263", State.NOT_VALID),
                new Customer(4L, "test 4", Country.UGANDA, "(256) 7734127498", State.NOT_VALID)
        );

        //when
        when(customerUseCase.getCustomers()).thenReturn(customers);

        //then
        final List<Customer> response = customerClassifierUsecaseImpl.getCustomerClassified();

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);

    }

}
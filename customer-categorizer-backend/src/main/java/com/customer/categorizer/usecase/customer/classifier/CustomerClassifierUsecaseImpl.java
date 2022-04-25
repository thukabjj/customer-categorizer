package com.customer.categorizer.usecase.customer.classifier;

import com.customer.categorizer.domain.customer.Country;
import com.customer.categorizer.usecase.customer.CustomerUseCase;
import com.customer.categorizer.domain.customer.Customer;
import com.customer.categorizer.domain.customer.State;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CustomerClassifierUsecaseImpl implements CustomerClassifierUsecase {
    private final CustomerUseCase customerUseCase;

    public CustomerClassifierUsecaseImpl(
            CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @Override
    public List<Customer> getCustomerClassified() {
        final List<Customer> customers = customerUseCase.getCustomers();

        var response = classifyCountryByCountry(customers);
        return response;
    }

    private List<Customer> classifyCountryByCountry(List<Customer> customers) {

        List<Customer> customersClassified = new ArrayList<>();

        Arrays.asList(Country.values()).forEach(country -> {

            final List<Customer> customerZone = filterCustomersByCountry(customers, country);

            final List<Customer> customersWithValidZoneIdPhoneNumber = getValidCustomerByZonePhoneNumberByCountry(country, customerZone);

            final List<Customer> customersWithInvalidZoneIdPhoneNumber = getInvalidCustomerByZonePhoneNumberByCountry(country, customerZone);

            final List<Customer> customersClassifiedByCountry = Stream.of(customersWithValidZoneIdPhoneNumber, customersWithInvalidZoneIdPhoneNumber)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            customersClassified.addAll(customersClassifiedByCountry);
            customersClassified.sort(Comparator.comparing(Customer::getId));
        });

        return customersClassified;
    }

    private List<Customer> getInvalidCustomerByZonePhoneNumberByCountry(Country country, List<Customer> customerZone) {
        final List<Customer> customersWithInvalidZoneIdPhoneNumber = customerZone.stream()
                .filter(c -> !Pattern.compile(country.getFullZoneIdAllowedPattern()).matcher(c.getPhone()).find())
                .map(c -> {
                    c.setCountry(country);
                    c.setState(State.NOT_VALID);
                    return c;
                }).collect(Collectors.toList());
        return customersWithInvalidZoneIdPhoneNumber;
    }

    private List<Customer> getValidCustomerByZonePhoneNumberByCountry(Country country, List<Customer> customerZone) {
        final List<Customer> customersWithValidZoneIdPhoneNumber = customerZone.stream()
                .filter(c -> Pattern.compile(country.getFullZoneIdAllowedPattern()).matcher(c.getPhone()).find())
                .map(c -> {
                    c.setCountry(country);
                    c.setState(State.VALID);
                    return c;
                }).collect(Collectors.toList());
        return customersWithValidZoneIdPhoneNumber;
    }

    private List<Customer> filterCustomersByCountry(List<Customer> customers, Country country) {
        final List<Customer> customerZone = customers.stream()
                .filter(c -> Pattern.compile(country.getPartialZoneIdAllowedPattern()).matcher(c.getPhone()).find())
                .collect(Collectors.toList());
        return customerZone;
    }

}

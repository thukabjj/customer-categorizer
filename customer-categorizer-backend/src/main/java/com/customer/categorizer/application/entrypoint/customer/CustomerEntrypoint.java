package com.customer.categorizer.application.entrypoint.customer;

import com.customer.categorizer.application.entrypoint.customer.entity.CustomerEntrypointResponse;
import com.customer.categorizer.application.mapper.customer.CustomerMapper;
import com.customer.categorizer.domain.customer.Customer;
import com.customer.categorizer.usecase.customer.classifier.CustomerClassifierUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")
public class CustomerEntrypoint {

    private final CustomerClassifierUsecase customerClassifierUsecase;

    private final CustomerMapper customerMapper;

    public CustomerEntrypoint(CustomerClassifierUsecase customerClassifierUsecase, CustomerMapper customerMapper) {
        this.customerClassifierUsecase = customerClassifierUsecase;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/v1/categorized")
    @Operation(summary = "Get - List of customers categorized by country.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Will returning list of customers categorized by country with successful."),
    })
    public ResponseEntity<List<CustomerEntrypointResponse>> getCustomersClassifiedByCountry() {
        final List<Customer> customerClassified = customerClassifierUsecase.getCustomerClassified();
        return ResponseEntity.ok(customerMapper.fromCustomerDomainToCustomerEntrypointResponse(customerClassifierUsecase.getCustomerClassified()));
    }
}

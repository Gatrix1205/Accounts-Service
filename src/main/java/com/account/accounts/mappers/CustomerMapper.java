package com.account.accounts.mappers;

import com.account.accounts.dto.CustomerDto;
import com.account.accounts.entities.Customer;

import java.time.LocalDateTime;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("GAtrix");
//        customer.setUpdatedAt(LocalDateTime.now());
//        customer.setUpdatedBy("Shankar");
        return customer;
    }
}

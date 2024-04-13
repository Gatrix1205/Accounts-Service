package com.account.accounts.services.impl;

import com.account.accounts.constants.AccountConstants;
import com.account.accounts.dto.AccountDto;
import com.account.accounts.dto.CustomerDto;
import com.account.accounts.entities.Account;
import com.account.accounts.entities.Customer;
import com.account.accounts.exceptions.CustomerAlreadyExistsException;
import com.account.accounts.exceptions.ResourceNotFoundException;
import com.account.accounts.mappers.AccountMapper;
import com.account.accounts.mappers.CustomerMapper;
import com.account.accounts.repository.AccountRepository;
import com.account.accounts.repository.CustomerRepository;
import com.account.accounts.services.IAccountServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor

public class AccountServicesImpl implements IAccountServices {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
//        customer.setCreatedAt(LocalDateTime.now());
//        customer.setCreatedBy("gsilldaf");
//        customer.setUpdatedAt(LocalDateTime.now());
//        customer.setUpdatedBy("dvxsdv");

        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered "+ customerDto.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));



    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Account account = accountRepository.findByCustomerId(customer.getCustomerId());

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountMapper.mapToAccountsDto(account, new AccountDto()));
        return customerDto;
    }

    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Gowri");
        newAccount.setUpdatedAt(LocalDateTime.now());
        newAccount.setUpdatedBy("Shankar");
        return newAccount;
    }
}

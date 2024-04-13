package com.account.accounts.services;

import com.account.accounts.dto.CustomerDto;
import com.account.accounts.mappers.CustomerMapper;

public interface IAccountServices {
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);
}

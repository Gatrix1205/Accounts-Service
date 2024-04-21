package com.account.accounts.services;

import com.account.accounts.dto.CustomerDto;



public interface IAccountServices {
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}

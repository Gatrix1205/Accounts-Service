package com.account.accounts.controller;


import com.account.accounts.constants.AccountConstants;
import com.account.accounts.dto.CustomerDto;
import com.account.accounts.dto.ResponseDto;
import com.account.accounts.services.IAccountServices;
import com.account.accounts.services.impl.AccountServicesImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private IAccountServices iAccountServices;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        iAccountServices.createAccount(customerDto);
        return ResponseEntity.status(
                HttpStatus.CREATED
        ).body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam String mobileNumber){
        CustomerDto customerDto = iAccountServices.fetchAccount(mobileNumber);
        return ResponseEntity.status(
                HttpStatus.ACCEPTED
        ).body(customerDto);
    }



}

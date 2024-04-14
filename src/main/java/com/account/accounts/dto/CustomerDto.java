package com.account.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {
    @Schema(
            description = "Name of the customer", example = "Eazy Bytes"
    )
    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Size(min = 0, max = 10, message = "Name cannot be larger than 10")
    private String name;


    @Schema(
            description = "Email address of the customer", example = "tutor@eazybytes.com"
    )

    @NotEmpty(message = "Email can not be a null or empty")
    @Email(message = "Email is not valid")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;
    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )

    private AccountDto accountDto;
}
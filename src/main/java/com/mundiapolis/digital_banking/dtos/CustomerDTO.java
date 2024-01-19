package com.mundiapolis.digital_banking.dtos;

import lombok.Data;
import com.mundiapolis.digital_banking.enums.Gender;
import lombok.Data;

import java.util.Date;
@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private String city;
    private Gender gender;
}

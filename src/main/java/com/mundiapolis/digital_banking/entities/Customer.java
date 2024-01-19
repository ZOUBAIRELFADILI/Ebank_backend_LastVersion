package com.mundiapolis.digital_banking.entities;

import com.mundiapolis.digital_banking.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity //pour le mapping
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private String city;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "customer") //type de relation est One To Many
    private List<BankAccount> bankAccounts;
}

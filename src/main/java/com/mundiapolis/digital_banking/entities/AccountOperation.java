package com.mundiapolis.digital_banking.entities;

import com.mundiapolis.digital_banking.enums.OperationType;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;
    @Enumerated(EnumType.STRING) //String : dans Base derd Donnes pur chaque type dans enum est string
    private OperationType type;
    @ManyToOne //plusieur operation pour un seule compte
    private BankAccount bankAccount;
    private String description;
}

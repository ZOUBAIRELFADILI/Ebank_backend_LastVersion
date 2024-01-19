package com.mundiapolis.digital_banking.entities;
import com.mundiapolis.digital_banking.enums.AccountStatus;
import jakarta.persistence.*;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4) //est utilise dans la strategy sing Table our definie le tyope de acconmete current accont or Savingacocount
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING) // ORDINAL: Status dans BD  est numerated chaque type have number(CREATED = 0 , ACTIVATED = 1, SUSPENDED = 3
    // STRING : Staus dans BD est String
    private AccountStatus status = AccountStatus.CREATED;

    @ManyToOne //un campte concern un client : Plusieur compte pour un client
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY) //UN compte peut faire plusieur operation mappedBy car la relayion est biderectionelle entre Account et Operation
    private List<AccountOperation> accountOperations; //eager: CHArge moi tous le attrinute et aussi les operation , layze: charge moi just lea attribute mais operation charge c'eat demande
}

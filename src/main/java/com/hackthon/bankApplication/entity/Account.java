package com.hackthon.bankApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private long accountNumber;
    private String accountType;
    private String ifscCode;
    private String bankName;
    private String branch;
    private boolean isBranchActive;
    private Date accountCreationDate;
    private long availableBalance;
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
}

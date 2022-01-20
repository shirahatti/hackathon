package com.hackthon.bankApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private long userId;
    private String password;
    private String firstName;
    private String lastName;
    private String panNumber;
    private Date dateOfBirth;
    private String mobileNumber;
    private String mailId;

}

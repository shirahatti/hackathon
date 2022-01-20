package com.hackthon.bankApplication.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountSummaryResponse {

    private String accountHolderName;
    private long accountNumber;
    private String accountType;
    private long availableBalance;
    private String accountCreationDate;

}

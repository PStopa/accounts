package com.kodilla.accounts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class GetAccountsResponse {

    public GetAccountsResponse(List<AccountDto> accounts) {
        this.accounts = accounts;
    }

    private List<AccountDto> accounts;

}
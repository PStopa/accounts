package com.kodilla.accounts.controller;

import com.kodilla.accounts.domain.Account;
import com.kodilla.accounts.domain.AccountDto;
import com.kodilla.accounts.domain.GetAccountsResponse;
import com.kodilla.accounts.mapper.AccountsMapper;
import com.kodilla.accounts.repository.AccountsRepository;
import com.kodilla.accounts.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class AccountsController {

    private final AccountsRepository repository;
    private final AccountsMapper mapper;
    private final AccountsService service;

    @Autowired
    public AccountsController(AccountsRepository repository, AccountsMapper mapper, AccountsService service) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/accounts")
    public GetAccountsResponse getAccounts(@RequestParam(required = false) Long customerId) {
        List<AccountDto> accountDtos = mapper.mapToAccountDtoList(service.getAllAccounts());
        return new GetAccountsResponse(accountDtos);
    }
}

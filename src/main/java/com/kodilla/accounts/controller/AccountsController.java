package com.kodilla.accounts.controller;

import com.kodilla.accounts.domain.Account;
import com.kodilla.accounts.domain.AccountDto;
import com.kodilla.accounts.domain.GetAccountsResponse;
import com.kodilla.accounts.mapper.AccountsMapper;
import com.kodilla.accounts.repository.AccountsRepository;
import com.kodilla.accounts.service.AccountsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AccountsController {

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    private final AccountsMapper mapper;
    private final AccountsService service;

    @GetMapping("/accounts")
    public GetAccountsResponse getAccounts(@RequestParam(required = false) Long customerId) {
        if(!allowGetAccounts) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        List<AccountDto> accountDtos = mapper.mapToAccountDtoList(service.getAllAccounts());
        return new GetAccountsResponse(accountDtos);
    }
}

package com.kodilla.accounts.repository;

import com.kodilla.accounts.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {

    @Override
    List<Account> findAll();
}

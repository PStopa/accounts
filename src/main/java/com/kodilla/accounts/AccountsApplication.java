package com.kodilla.accounts;

import com.kodilla.accounts.domain.Account;
import com.kodilla.accounts.repository.AccountsRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountsApplication {

	@Autowired
	private AccountsRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			repository.save(new Account(1L, "72249000059957936727967706", "PLN",
					new BigDecimal("6525.11")));
		};
	}
}

package com.emer.bookmarks.repository.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emer.bookmarks.model.Account;
import com.emer.bookmarks.repository.AccountOwnRepository;
import com.emer.bookmarks.repository.AccountRepository;
import com.emer.bookmarks.repository.AccountService;

@Service
@Transactional
public class AccountServiceImplementation implements AccountService{
	@Autowired
	private AccountOwnRepository accountOwnRepository;
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Optional<Account> findByUsername(String name) {
		return accountOwnRepository.findByUsername(name);
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}
	
	
}

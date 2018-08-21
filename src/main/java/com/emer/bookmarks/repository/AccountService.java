package com.emer.bookmarks.repository;

import java.util.Optional;

import com.emer.bookmarks.model.Account;

public interface AccountService {
	Optional<Account> findByUsername(String name);
	Account save(Account account);
}

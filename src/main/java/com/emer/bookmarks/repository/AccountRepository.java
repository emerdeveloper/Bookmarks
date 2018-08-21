package com.emer.bookmarks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emer.bookmarks.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}

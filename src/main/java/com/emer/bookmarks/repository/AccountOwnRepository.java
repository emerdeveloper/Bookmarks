package com.emer.bookmarks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.emer.bookmarks.model.Account;

public interface AccountOwnRepository extends Repository<Account, Long>{
	@Query(value = "select a from Account a where a.username = :username")
	Optional<Account> findByUsername (@Param("username") String name);
}

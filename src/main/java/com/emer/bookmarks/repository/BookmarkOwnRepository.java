package com.emer.bookmarks.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.emer.bookmarks.model.Bookmark;

public interface BookmarkOwnRepository extends Repository<Bookmark, Long>{
	@Query(value = "SELECT b from Bookmark b WHERE b.account.username = :username")
	Collection<Bookmark> findByAccountUsername(@Param("username") String username);
}

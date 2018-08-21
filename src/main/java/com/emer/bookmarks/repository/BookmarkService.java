package com.emer.bookmarks.repository;

import java.util.Collection;

import com.emer.bookmarks.model.Bookmark;

public interface BookmarkService {
	Collection<Bookmark> findByAccountUsername(String username);
	Bookmark save(Bookmark bookmark);
	Bookmark findOne(Long id);
}

package com.emer.bookmarks.repository.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emer.bookmarks.model.Bookmark;
import com.emer.bookmarks.repository.BookmarkOwnRepository;
import com.emer.bookmarks.repository.BookmarkRepository;
import com.emer.bookmarks.repository.BookmarkService;

@Service
@Transactional
public class BookmarkServiceImplementation implements BookmarkService{
	@Autowired
	private BookmarkOwnRepository boomarkOwnRepository;
	@Autowired
	private BookmarkRepository bookmarkRepository;

	@Override
	public Collection<Bookmark> findByAccountUsername(String username) {
		return boomarkOwnRepository.findByAccountUsername(username);
	}

	@Override
	public Bookmark save(Bookmark bookmark) {
		return bookmarkRepository.save(bookmark);
	}

	@Override
	public Bookmark findOne(Long id) {
		return bookmarkRepository.findOne(id);
	}

}

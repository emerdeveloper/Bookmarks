package com.emer.bookmarks.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emer.bookmarks.controller.Exception.UserNotFoundException;
import com.emer.bookmarks.model.Bookmark;
import com.emer.bookmarks.repository.AccountService;
import com.emer.bookmarks.repository.BookmarkService;

import java.net.URI;

@RestController
@RequestMapping("/{userId}/bookmarks")
public class BookmarkController {
	
	private final BookmarkService bookmarkService;
	private final AccountService accountService;

	
	@Autowired
	public BookmarkController(BookmarkService bookmarkService, AccountService accountService) {
		this.bookmarkService = bookmarkService;
		this.accountService = accountService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	Collection<Bookmark> readBookmars(@PathVariable String userId){
		this.validateUser(userId);
		return bookmarkService.findByAccountUsername(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input){
		this.validateUser(userId);
		
		return this.accountService
				.findByUsername(userId)
				.map(account -> {
					Bookmark result = bookmarkService.save(
										new Bookmark(account, input.getUri(), input.getDescription()));
					
					URI location = ServletUriComponentsBuilder
							.fromCurrentRequest().path("{id}")
							.buildAndExpand(result.getId()).toUri();
					
					return ResponseEntity.created(location).build();
				})
				.orElse(ResponseEntity.noContent().build());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{bookmarkId}")
	Bookmark readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId){
		this.validateUser(userId);
		return this.bookmarkService.findOne(bookmarkId);
	}
	
	private void validateUser(String userId){
		this.accountService.findByUsername(userId).orElseThrow(() -> new UserNotFoundException(userId));
	}
}

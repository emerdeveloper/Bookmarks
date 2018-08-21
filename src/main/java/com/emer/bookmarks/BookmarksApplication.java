package com.emer.bookmarks;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.emer.bookmarks.model.Account;
import com.emer.bookmarks.model.Bookmark;
import com.emer.bookmarks.repository.AccountService;
import com.emer.bookmarks.repository.BookmarkService;

@SpringBootApplication
public class BookmarksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarksApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(BookmarkService bookmarkService, AccountService accountService) {
		return (evt) -> Arrays.asList(
				"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
				.forEach(
						a -> {
							Account account = accountService.save(new Account(a,
									"password"));
							bookmarkService.save(new Bookmark(account,
									"http://bookmark.com/1/" + a, "A description"));
							bookmarkService.save(new Bookmark(account,
									"http://bookmark.com/2/" + a, "A description"));
						});
	}
}

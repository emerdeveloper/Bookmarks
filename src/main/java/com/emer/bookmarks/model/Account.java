package com.emer.bookmarks.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Emerson Javid Gonzalez Morales
 * 
 * Each Account may have no, one, or many Bookmark entities. This is a 1:N relationship.
 *
 */

@Entity
public class Account {
	
	@OneToMany(mappedBy = "account")
	private Set<Bookmark> bookmarks = new HashSet<>();
	
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonIgnore
	private String password;
	private String username;
	
	public Account() {
		super();
	}

	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(Set<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}
	
}

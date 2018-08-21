package com.emer.bookmarks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emer.bookmarks.model.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long>{

}

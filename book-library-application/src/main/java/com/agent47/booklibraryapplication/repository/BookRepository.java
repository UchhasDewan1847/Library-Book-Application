package com.agent47.booklibraryapplication.repository;

import com.agent47.booklibraryapplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    Book findByAuthorName(String authorName);
    void deleteByBookName(String bookName);



}

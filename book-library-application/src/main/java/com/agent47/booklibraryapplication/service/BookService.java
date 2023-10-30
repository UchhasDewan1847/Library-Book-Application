package com.agent47.booklibraryapplication.service;

import com.agent47.booklibraryapplication.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();

    Book getById(String bookid);

    Book getByAuthorName(String authorName);

    String addBook(Book book);

    String updateBook(Book book, String bookId);

    String deleteByName(String name);

    void addBooks(List<Book> books);
}

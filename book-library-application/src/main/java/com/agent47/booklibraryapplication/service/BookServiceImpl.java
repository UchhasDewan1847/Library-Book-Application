package com.agent47.booklibraryapplication.service;

import com.agent47.booklibraryapplication.entity.Book;
import com.agent47.booklibraryapplication.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    final private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Double bookid) {
        return bookRepository.findById(bookid).get();
    }

    @Override
    public Book getByAuthorName(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }

    @Override
    public String addBook(Book book) {
        bookRepository.save(book);
        return "Book Saved";
    }

    @Override
    public void addBooks(List<Book> books) {
        bookRepository.saveAll(books);

    }

    @Override
    public String updateBook(Book book, Double bookId) {
        Book book1=bookRepository.findById(bookId).get();
        if(Objects.nonNull(book.getBookName())&& (!"".equalsIgnoreCase(book.getBookName()))){
            book1.setBookName(book.getBookName());
        }
        if(Objects.nonNull(book.getAuthorName())&& (!"".equalsIgnoreCase(book.getAuthorName()))){
            book1.setAuthorName(book.getAuthorName());
        }
        bookRepository.save(book1);
        return "Book updated";
    }

    @Transactional
    @Override
    public String deleteByName(String name) {
        bookRepository.deleteByBookName(name);
        return "book deleted";
    }
}

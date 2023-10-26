package com.agent47.booklibraryapplication.controller;

import com.agent47.booklibraryapplication.entity.Book;
import com.agent47.booklibraryapplication.service.BookService;
import com.agent47.booklibraryapplication.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookServiceImpl bookServiceimpl;

    @GetMapping("/books/all")
    public List<Book> getAllBooks(){
        return bookServiceimpl.getAllBooks();
    }
    @GetMapping("/books/id/{id}")
    public Book getById(@PathVariable("id") String bookid){
        return bookServiceimpl.getById(bookid);
    }

    @GetMapping("/books/name/{author_name}")
    public Book getByAuthorName(@PathVariable("author_name") String authorName) {
        return bookServiceimpl.getByAuthorName(authorName);
    }

    @PostMapping("/books/create")
    public  String addBook(@RequestBody Book book){
        return bookServiceimpl.addBook(book);
    }
    @PutMapping("/books/update/{id}")
    public  String updateBook(@RequestBody Book book,@PathVariable("id") String bookId){
        return bookServiceimpl.updateBook(book,bookId);
    }

    @DeleteMapping("/books/delete/{name}")
    public String deleteByName(@PathVariable("name") String name){
        return bookServiceimpl.deleteByName(name);
    }

}

package org.krejo.controller;

import org.krejo.data.models.book.BookResource;
import org.krejo.data.services.BookDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class MyController {
    @Autowired
    BookDataService bookDataService;

    @GetMapping("/borrow/allowed/{userId}/{bookId}")
    public boolean getBorrowBookAllowed(@PathVariable int userId, @PathVariable int bookId) {
        return bookDataService.getBorrowBookAllowed(userId, bookId);
    }

    @GetMapping("/borrow/{userId}/{bookId}")
    public BookResource borrowBook(@PathVariable int userId, @PathVariable int bookId) {
        return bookDataService.borrowBook(userId, bookId);
    }

    @GetMapping("/borrow/allowed")
    public List<BookResource> getBorrowableBooks() {
        return bookDataService.getAllBooks();
    }

    @GetMapping("/borrow/{userId}")
    public List<BookResource> borrowBook(@PathVariable int userId) {
        return bookDataService.getUserBooks(userId);
    }
}

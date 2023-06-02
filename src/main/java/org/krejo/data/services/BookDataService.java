package org.krejo.data.services;

import org.krejo.data.models.book.BookEntity;
import org.krejo.data.models.book.BookResource;
import org.krejo.database.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDataService {
    @Autowired
    BookRepo bookRepo;
    public int getBookCount() {
        List<BookEntity> books = (List<BookEntity>) bookRepo.findAll();
        return (int) books.stream().count();
    }

    public List<BookResource> getAllBooksFromAuthor(String authorName) {
        List<BookEntity> books =  (List<BookEntity>) bookRepo.findAll();
        List<BookResource> bookResources = books
                .stream()
                .filter(entity -> entity.getAuthor().equals(authorName))
                .map(this::convertBookEntityToBookResource)
                .toList();

        return bookResources;
    }

    public Map<String, Integer> getBookCountFromPublisher() {
        Map<String, Integer> map = new HashMap<>();
        return map;
    }

    public String getAverageYear() {
        return "SmartSced :)";
    }

    public List<BookResource> getRange() {
        return new ArrayList<>();
    }

    private BookResource convertBookEntityToBookResource(BookEntity bookEntity) {
        BookResource bookResource = new BookResource();

        bookResource.setAuthor(bookEntity.getAuthor());
        bookResource.setId(bookEntity.getId());
        bookResource.setYear(bookEntity.getYear());
        bookResource.setIsbn(bookEntity.getIsbn());
        bookResource.setTitle(bookEntity.getTitle());
        bookResource.setPublisher(bookEntity.getPublisher());

        return bookResource;
    }

    public boolean getBorrowBookAllowed(int userId, int bookId) {
        return false;
    }

    public BookResource borrowBook(int userId, int bookId) {
        return null;
    }

    public List<BookResource> getAllBooks() {
        return new ArrayList<>();
    }

    public List<BookResource> getUserBooks(int userId) {
        return new ArrayList<>();
    }
}

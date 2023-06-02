package org.krejo.controller;

import org.krejo.data.models.book.BookResource;
import org.krejo.data.models.library.LibraryResource;
import org.krejo.data.services.BookDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class FunctionController {
    @Autowired
    BookDataService bookDataService;
    @GetMapping("/books/count")
    public int getAllLibraries() {
        return bookDataService.getBookCount();
    }

    @GetMapping("/books/author/{authorName}")
    public List<BookResource> getBooksOfAuthor(@PathVariable String authorName) {
        return bookDataService.getAllBooksFromAuthor(authorName);
    }

    @GetMapping("/books/publisher/count")
    public Map<String, Integer> getBooksOfPublisher() {
        return bookDataService.getBookCountFromPublisher();
    }

    @GetMapping("/books/year/average")
    public String getAverageYear() {
        return bookDataService.getAverageYear();
    }

    @GetMapping("/books/year/Range")
    public List<BookResource> getRange() {
        return bookDataService.getRange();
    }



}

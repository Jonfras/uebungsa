package org.krejo.controller;


import org.krejo.data.exception.BookBadDTOException;
import org.krejo.data.exception.IllegalBookException;
import org.krejo.data.exception.IllegalLibraryException;
import org.krejo.data.exception.LibraryBadDTOException;
import org.krejo.data.models.book.BookDTO;
import org.krejo.data.models.book.BookResource;
import org.krejo.data.models.library.LibraryDTO;
import org.krejo.data.models.library.LibraryResource;
import org.krejo.data.services.BookDataService;
import org.krejo.data.services.LibraryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    BookDataService bookDataService;
    @Autowired
    LibraryDataService libraryDataService;

    @GetMapping("/libraries")
    public List<LibraryResource> getAllLibraries() {
        return libraryDataService.getAllLibraries();
    }
    @GetMapping("/libraries/{libId}")
    public LibraryResource getStore(@PathVariable int libId)
            throws IllegalLibraryException {
        return libraryDataService.getLibrary(libId);
    }

    @PostMapping("/libraries")
    public LibraryResource addStore(@RequestBody LibraryDTO libraryDTO) throws LibraryBadDTOException {
        return libraryDataService.addLibrary(libraryDTO);
    }

    @PutMapping("/libraries/{libId}")
    public LibraryResource editStore(@PathVariable int libId, @RequestBody LibraryDTO libraryDTO) throws LibraryBadDTOException, IllegalLibraryException {
        return libraryDataService.editLibrary(libId, libraryDTO);
    }

    @DeleteMapping("/libraries/{libId}")
    public LibraryResource deleteStore(@PathVariable int libId) throws IllegalLibraryException {
        return libraryDataService.deleteLibrary(libId);
    }

    @GetMapping("/libraries/{libId}/books")
    public List<BookResource> getBooks(@PathVariable int libId) throws IllegalLibraryException {
        return libraryDataService.getBooks(libId);
    }

    @GetMapping("/libraries/{libId}/books/{bookId}")
    public BookResource getProduct(@PathVariable int libId, @PathVariable int bookId) throws IllegalBookException, IllegalLibraryException {
        return libraryDataService.getBook(libId, bookId);
    }

    @PostMapping("/libraries/{libId}/books")
    public BookResource addProduct(@PathVariable int storeId, @RequestBody BookDTO bookDTO) throws IllegalLibraryException , BookBadDTOException{
        return libraryDataService.addBook(storeId, bookDTO);
    }

    @PutMapping("/libraries/{libraryId}/books/{bookId}")
    public BookResource editProduct(@PathVariable int storeId, @PathVariable int productId, @RequestBody BookDTO bookDTO) throws IllegalLibraryException, IllegalBookException, BookBadDTOException {
        return libraryDataService.editBook(storeId, productId, bookDTO);
    }

    @DeleteMapping("/libraries/{libId}/books/{bookId}")
    public BookResource deleteProduct(@PathVariable int storeId, @PathVariable int productId) throws IllegalLibraryException, IllegalBookException {
        return libraryDataService.deleteBook(storeId, productId);
    }

}

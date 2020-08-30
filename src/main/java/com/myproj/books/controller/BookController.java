package com.myproj.books.controller;

import com.myproj.books.DTO.BookDTO;
import com.myproj.books.exception.BookNotFoundException;
import com.myproj.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/all")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable(value = "id") final Long id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }

    @PostMapping("/book/add")
    public void addBook(@RequestBody final BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }

    @PostMapping("/book/bulk")
    public void addBooks(@RequestBody final List<BookDTO> bookDTOs) {
        bookService.addBooks(bookDTOs);
    }

    @DeleteMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable final Long id) {
        bookService.deleteBook(id);
    }

    @DeleteMapping("/book/delete/all")
    public void deleteAllBooks() {
        bookService.deleteAllBooks();
    }


}

package com.myproj.books.service;

import com.myproj.books.DTO.BookDTO;
import com.myproj.books.exception.BookNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();
    ResponseEntity<BookDTO> getBookById(final Long id) throws BookNotFoundException;
    void addBook(final BookDTO bookDTO);
    void addBooks(final List<BookDTO> bookDTOs);
    void deleteBook(final Long id);
    void deleteAllBooks();
}

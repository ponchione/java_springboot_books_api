package com.myproj.books.service;

import com.myproj.books.DTO.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();
    BookDTO getBookById(final Long id);
}

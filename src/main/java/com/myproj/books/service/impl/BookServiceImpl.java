package com.myproj.books.service.impl;

import com.myproj.books.DTO.BookDTO;
import com.myproj.books.repository.BookRepository;
import com.myproj.books.service.BookService;
import com.myproj.books.util.BookServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        final List<BookDTO> list = new ArrayList<>();
        bookRepo.findAll().forEach(
                book -> list.add(BookServiceUtil.toBookDTO(book))
        );

        return list;
    }

    @Override
    public BookDTO getBookById(final Long id) {
        return BookServiceUtil.toBookDTO(bookRepo.findById(id).get());
    }
}

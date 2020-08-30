package com.myproj.books.service.impl;

import com.myproj.books.DTO.BookDTO;
import com.myproj.books.exception.BookNotFoundException;
import com.myproj.books.repository.BookRepository;
import com.myproj.books.service.BookService;
import com.myproj.books.util.mapping.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    private final BookMapper mapper = BookMapper.INSTANCE;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return mapper.booksToBookDTOs(bookRepo.findAll());
    }

    @Override
    public ResponseEntity<BookDTO> getBookById(final Long id) throws BookNotFoundException {
        final BookDTO dto = mapper.bookToBookDTO(
                bookRepo.findById(id).orElseThrow(
                        () -> new BookNotFoundException("Book could not be found this id: " + id)
                )
        );

        return ResponseEntity.ok().body(dto);
    }

    @Override
    public void addBook(final BookDTO bookDTO) {
        bookRepo.save(mapper.bookDtoToBook(bookDTO));
    }


    @Override
    public void addBooks(final List<BookDTO> bookDTOs) {
        bookRepo.saveAll(mapper.bookDTOsToBooks(bookDTOs));
    }
}

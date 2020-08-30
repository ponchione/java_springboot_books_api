package com.myproj.books.common;

import com.myproj.books.DTO.BookDTO;
import com.myproj.books.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookSetupUtil {
    public static Book getBook() {
        return createBook(
                1,
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                "9780743273565"
        );
    }


    public static Book createBook(final long id,
                                  final String bookName,
                                  final String author,
                                  final String isbn) {
        return new Book(id, bookName, author, isbn);
    }


    public static List<Book> getListOfBooks() {
        final List<Book> books = new ArrayList<>();
        books.add(getBook());
        books.add(createBook(
                2,
                "The Hunger Games",
                "Suzanne Collins",
                "978-0439023481"
        ));

        books.add(createBook(
                3,
                "Eragon",
                "Christopher Paolini",
                "978-0375826696"
        ));

        return books;
    }


    public static BookDTO getBookDTO() {
        return createBookDTO(
                1,
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                "9780743273565"
        );
    }


    public static BookDTO createBookDTO(final long id,
                                        final String bookName,
                                        final String author,
                                        final String isbn) {
        return new BookDTO(id, bookName, author, isbn);
    }


    public static List<BookDTO> getListOfBookDTOs() {
        final List<BookDTO> dtos = new ArrayList<>();
        dtos.add(getBookDTO());
        dtos.add(createBookDTO(
                2,
                "The Hunger Games",
                "Suzanne Collins",
                "978-0439023481"
        ));

        dtos.add(createBookDTO(
                3,
                "Eragon",
                "Christopher Paolini",
                "978-0375826696"
        ));

        return dtos;
    }


}//END CLASS

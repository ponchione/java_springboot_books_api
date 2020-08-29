package com.myproj.books.util;

import com.myproj.books.DTO.BookDTO;
import com.myproj.books.model.Book;

public class BookServiceUtil {

    public static BookDTO toBookDTO(final Book book) {
        final BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setAuthor(book.getAuthor());
        dto.setBookName(book.getBookName());
        dto.setIsbn(book.getIsbn());

        return dto;
    }



}

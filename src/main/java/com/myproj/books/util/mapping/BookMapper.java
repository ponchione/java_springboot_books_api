package com.myproj.books.util.mapping;

import com.myproj.books.DTO.BookDTO;
import com.myproj.books.model.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    //Instance of mapper
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    //Map from Book to BookDTO
    BookDTO bookToBookDTO(final Book book);

    //Map from BookDTO to Book
    @InheritInverseConfiguration
    Book bookDtoToBook(final BookDTO bookDTO);

    //Map list of BookDTOs to Books
    List<Book> bookDTOsToBooks(final List<BookDTO> dtos);

    //Map list of Books to BookDTOs
    @InheritInverseConfiguration
    List<BookDTO> booksToBookDTOs(final List<Book> books);
}

package com.myproj.books.utils;

import com.myproj.books.DTO.BookDTO;
import com.myproj.books.model.Book;
import com.myproj.books.util.mapping.BookMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Mapstruct book mapping implementation test case")
public class TestBookMapper {

    final BookMapper mapper = BookMapper.INSTANCE;

    public Book createBook() {
        final Book book = new Book();
        book.setAuthor("F. Scott Fitzgerald");
        book.setBookName("The Great Gatsby");
        book.setId((long) 1);
        book.setIsbn("9780743273565");

        return book;
    }

    @Test
    @DisplayName("One to one Book to BookDTO mapping")
    public void testBookToBookDTO() {
        final Book orig = createBook();
        BookDTO dto;
        Book temp;

        dto = mapper.bookToBookDTO(orig);
        temp = mapper.bookDtoToBook(dto);

        Assertions.assertEquals(temp.getAuthor(), orig.getAuthor());
        Assertions.assertEquals(temp.getBookName(), orig.getBookName());
        Assertions.assertEquals(temp.getId(), orig.getId());
        Assertions.assertEquals(temp.getIsbn(), orig.getIsbn());
    }//END

    @Test
    @DisplayName("Book list to BookDTO list mapping")
    public void testBooksToBookDTOs() {
        final List<Book> origBooks = new ArrayList<>();
        origBooks.add(createBook());
        final List<BookDTO> dtoList;
        final List<Book> tempList;

        dtoList = mapper.booksToBookDTOs(origBooks);
        tempList = mapper.bookDTOsToBooks(dtoList);

        Assertions.assertEquals(tempList.size(), origBooks.size());
        Assertions.assertEquals(tempList.get(0).getIsbn(), origBooks.get(0).getIsbn());
        Assertions.assertEquals(tempList.get(0).getId(), origBooks.get(0).getId());
        Assertions.assertEquals(tempList.get(0).getBookName(), origBooks.get(0).getBookName());
        Assertions.assertEquals(tempList.get(0).getAuthor(), origBooks.get(0).getAuthor());
    }//END

}

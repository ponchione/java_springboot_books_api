package com.myproj.books.service;


import com.myproj.books.DTO.BookDTO;
import com.myproj.books.common.BookSetupUtil;
import com.myproj.books.controller.BookController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestBookService {

    @InjectMocks
    BookController controller;

    @Mock
    BookService service;

    @BeforeAll
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetAllBooks() {
        final List<BookDTO> dtos = BookSetupUtil.getListOfBookDTOs();
        when(service.getAllBooks()).thenReturn(dtos);
        List<BookDTO> dtoList = controller.getAllBooks();

        Assertions.assertEquals(dtoList.size(), 3);
    }


}

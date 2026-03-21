package com.mahesha.catalog_service.service;

import java.util.List;

import com.mahesha.catalog_service.dto.BookDto;

public interface BookService {

    BookDto createBook(BookDto bookDto);
    BookDto getBookById(String id);
    List<BookDto> getAllBooks();
    BookDto updateBook(String id, BookDto bookDto);
    void deleteBook(String id);
    
}

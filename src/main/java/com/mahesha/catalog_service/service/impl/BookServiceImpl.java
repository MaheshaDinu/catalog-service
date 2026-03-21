package com.mahesha.catalog_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mahesha.catalog_service.dto.BookDto;
import com.mahesha.catalog_service.entity.Book;
import com.mahesha.catalog_service.mapper.BookMapper;
import com.mahesha.catalog_service.repository.BookRepo;
import com.mahesha.catalog_service.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    
    private final BookRepo bookRepository;
    private final BookMapper bookMapper;
    
    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book  = bookMapper.toEntity(bookDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public BookDto getBookById(String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(String id, BookDto bookDto) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        existingBook.setTitle(bookDto.getTitle());
        existingBook.setAuthor(bookDto.getAuthor());
        existingBook.setIsbn(bookDto.getIsbn());
        existingBook.setDescription(bookDto.getDescription());
        existingBook.setCoverImageUrl(bookDto.getCoverImageUrl());
        existingBook.setPdfFileUrl(bookDto.getPdfFileUrl());

        Book updatedBook = bookRepository.save(existingBook);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
    
}

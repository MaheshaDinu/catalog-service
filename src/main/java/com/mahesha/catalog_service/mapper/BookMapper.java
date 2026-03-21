package com.mahesha.catalog_service.mapper;

import org.mapstruct.Mapper;

import com.mahesha.catalog_service.dto.BookDto;
import com.mahesha.catalog_service.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);
    Book toEntity(BookDto bookDto);
}

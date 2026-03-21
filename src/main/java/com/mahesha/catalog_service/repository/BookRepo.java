package com.mahesha.catalog_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mahesha.catalog_service.entity.Book;

public interface BookRepo extends MongoRepository<Book, String> {
    
}

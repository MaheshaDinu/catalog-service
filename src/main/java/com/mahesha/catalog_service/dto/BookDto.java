package com.mahesha.catalog_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private String id;
    private String title;
    private String author;
    private String description;
    private String isbn;

    private String coverImageUrl;
    private String pdfFileUrl;

    
}

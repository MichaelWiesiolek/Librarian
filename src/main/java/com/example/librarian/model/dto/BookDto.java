package com.example.librarian.model.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class BookDto {
    private  int id;
    private String author;
    private String title;
    private String publisher;
    private String category;
    private LocalDate releaseDate;
}

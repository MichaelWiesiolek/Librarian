package com.example.librarian.service;

import com.example.librarian.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    private final BooksRepository booksRepository;
    @Autowired
    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }
}

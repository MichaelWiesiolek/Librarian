package com.example.librarian.controller;

import com.example.librarian.repository.dao.BooksEntity;
import com.example.librarian.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(orgins = "http://localhost:4200")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService){this.booksService = booksService;}


    @RequestMapping(method = RequestMethod.GET, path = "/books")
    public List<BooksEntity> getAllBooks() {return booksService.getAllBooks();}

    @RequestMapping(method = RequestMethod.GET, path = "/books", params = {"sortBy"})
    public List<BooksEntity> getSortedBooks(@RequestParam(name = "sortBy", required = false) String parameter) {
        return booksService.getSortedBooks(parameter);
        }

    }


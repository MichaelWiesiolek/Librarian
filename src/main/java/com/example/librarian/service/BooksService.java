package com.example.librarian.service;

import com.example.librarian.repository.BooksRepository;
import com.example.librarian.repository.dao.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;
    @Autowired
    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public void addNewBook(String author, String title, String publisher, String category, LocalDate releaseDate){
        BooksEntity entity = new BooksEntity();
        entity.setAuthor(author);
        entity.setTitle(title);
        entity.setPublisher(publisher);
        entity.setCategory(category);
        entity.setReleaseDate(releaseDate);
        booksRepository.save(entity);
    }


    public void removeBook( int id){
        booksRepository.deleteById(id);

    }

    public List<BooksEntity> getAllBooks(){
        List<BooksEntity> allBooks = booksRepository.findAll();
        return allBooks;
    }

    public List<BooksEntity> getSortedBooks(String parameter) {
        List<BooksEntity> allBooks = booksRepository.findAll();
        switch (parameter) {
            case "author" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getAuthor));
                return allBooks;
            }
            case "title" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getTitle));
                return allBooks;
            }
            case "publisher" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getPublisher));
                return allBooks;
            }
            case "category" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getCategory));
                return allBooks;
            }
            case "releaseDate" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getReleaseDate));
                return allBooks;
            }
            default -> {
                return allBooks;
            }
        }
    }

}
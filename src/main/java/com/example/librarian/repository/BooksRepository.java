package com.example.librarian.repository;

import com.example.librarian.repository.dao.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {
}

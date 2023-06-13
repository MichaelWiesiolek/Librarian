package com.example.librarian.dataProvider;

import com.example.librarian.repository.BooksRepository;
import com.example.librarian.repository.dao.BooksEntity;
import com.example.librarian.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BookIndexH2DataProvider implements ComandLineRunner {
    private final BooksRepository booksRepository;
    private final BooksService booksService;

    @Autowired
    public BookIndexH2DataProvider(BooksRepository booksRepository, BooksService booksService) {
        this.booksRepository = booksRepository;
        this.booksService = booksService;
    }

    @Value("classpath:bookIndex.txt")
    private Resource resource;

    @Override
    public void run(String... args) throws Exception {
        String filePathString = resource.getFile().getPath();
        Path of = Path.of(filePathString);
        List<BooksEntity> collect = Files.readAllLines(of)
                .stream()
                .map(x -> x.split(","))
                .map(x -> BooksEntity
                        .builder()
                        .author(x[0])
                        .title(x[1])
                        .publisher(x[2])
                        .category(x[3])
                        .releaseDate(LocalDate.parse(x[4].concat("-").concat(x[5]).concat("-").concat(x[6])))
                        .build())
                .collect(Collectors.toList());

        collect.forEach(booksEntity -> booksService.addNewBook(booksEntity.getAuthor(), booksEntity.getTitle(), booksEntity.getPublisher(), booksEntity.getCategory(), booksEntity.getReleaseDate()));
    }
}

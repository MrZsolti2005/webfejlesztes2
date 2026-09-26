package hu.inf.unideb.library.repository;

import hu.inf.unideb.library.model.Book;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findById(
            @NonNull String isbn
    );

    Book create(
            @NonNull Book book
    );

    Book update(
            @NonNull Book book
    );

    void deleteById(
            @NonNull String isbn
    );
}

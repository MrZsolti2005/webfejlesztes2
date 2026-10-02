package hu.inf.unideb.library.repository;

import hu.inf.unideb.library.model.Book;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository{

    private final Map<String, Book> books;

    public BookRepositoryImpl() {
        books = new HashMap<>();
    }

    @Override
    public List<Book> findAll() {
        return books.values().stream().sorted(Comparator.comparing(Book::getIsbn)).toList();
    }

    @Override
    public Optional<Book> findById(@NonNull String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    @Override
    public Book create(@NonNull Book book) {
        final var updated = book
                .withCreated(OffsetDateTime.now())
                .withUpdated(OffsetDateTime.now());
        books.put(book.getIsbn(), updated);
        return updated;
    }

    @Override
    public Book update(@NonNull Book book) {
        return book
                .withUpdated(OffsetDateTime.now());
    }

    @Override
    public void deleteById(@NonNull String isbn) {
        books.remove(isbn);
    }
}

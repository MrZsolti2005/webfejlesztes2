package hu.inf.unideb.library.web;

import com.github.javafaker.Faker;
import hu.inf.unideb.library.model.Book;
import hu.inf.unideb.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController{

    private static final Logger LOGGER = LoggerFactory.getLogger(BookControllerImpl.class);
    private final BookRepository repository;
    private static final Faker FAKER = new Faker();

    @Override
    public Book getOne(String isbn) {
        LOGGER.info("getOne({})", isbn);

        return repository
                .findById(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A könyv nem található ezzel az ISBN-nel: " + isbn));
    }

    @Override
    public List<Book> getAll() {
        LOGGER.info("getAll()");

        return repository.findAll();
    }

    @Override
    public Book createOne(Book book) {
        LOGGER.info("createOne({})", book);

        return repository.save(book.withIsbn(FAKER.code().isbn13()))
                .withCreated(OffsetDateTime.now())
                .withUpdated(OffsetDateTime.now());
    }

    @Override
    public Book updateOne(Book book) {
        LOGGER.info("updateOne({})", book);

        return Optional.of(book)
                .map(Book::getIsbn)
                .flatMap(repository::findById)
                .map(b -> {
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setPublisher(book.getPublisher());
                    b.setGenre(book.getGenre());
                    b.setPageCount(book.getPageCount());
                    b.setPublicationYear(book.getPublicationYear());
                    b.setUpdated(OffsetDateTime.now());
                    return b;
                })
                .map(repository::save)
                .orElseThrow();
    }

    @Override
    public void deleteOne(String isbn) {
        LOGGER.info("deleteOne({})", isbn);
        repository.deleteById(isbn);
    }
}

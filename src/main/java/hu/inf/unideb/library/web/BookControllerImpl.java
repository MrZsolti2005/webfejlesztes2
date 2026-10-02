package hu.inf.unideb.library.web;

import com.github.javafaker.Faker;
import hu.inf.unideb.library.model.Book;
import hu.inf.unideb.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

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

        return repository.findById(isbn).orElseThrow();
    }

    @Override
    public List<Book> getAll() {
        LOGGER.info("getAll()");

        return repository.findAll();
    }

    @Override
    public Book createOne(Book book) {
        LOGGER.info("createOne({})", book);

        return repository.create(book.withIsbn(FAKER.code().isbn13()));
    }

    @Override
    public Book updateOne(Book book) {
        LOGGER.info("updateOne({})", book);

        return Optional.of(book)
                .map(Book::getIsbn)
                .flatMap(repository::findById)
                .map(b -> b
                        .withTitle(book.getTitle())
                        .withAuthor(book.getAuthor())
                        .withGenre(book.getGenre())
                        .withPublisher(book.getPublisher())
                        .withYear(book.getYear())
                        .withPageCount(book.getPageCount()))
                .map(repository::update)
                .orElseThrow();
    }

    @Override
    public void deleteOne(String isbn) {
        LOGGER.info("deleteOne({})", isbn);
        repository.deleteById(isbn);
    }
}

package hu.inf.unideb.library.runner;

import com.github.javafaker.Faker;
import hu.inf.unideb.library.model.Book;
import hu.inf.unideb.library.repository.BookRepository;
import hu.inf.unideb.library.repository.BookRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class BookRunner implements CommandLineRunner {

    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();
    private final BookRepository repository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(
                    repository.create(
                            Book.builder()
                                    .isbn(FAKER.code().isbn13())
                                    .title(FAKER.book().title())
                                    .author(FAKER.book().author())
                                    .genre(Book.Genre.FANTASY)
                                    .publisher(FAKER.book().publisher())
                                    .year(RANDOM.nextInt(1950,2026))
                                    .pageCount(RANDOM.nextInt(40,600))
                                    .build()
                    )
            );
        }
    }
}

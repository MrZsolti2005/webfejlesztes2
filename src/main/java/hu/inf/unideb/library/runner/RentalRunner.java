package hu.inf.unideb.library.runner;

import hu.inf.unideb.library.model.Rental;
import hu.inf.unideb.library.repository.BookRepository;
import hu.inf.unideb.library.repository.MemberRepository;
import hu.inf.unideb.library.repository.RentalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
@Order(2)
public class RentalRunner implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        final var member = memberRepository
                .findAll()
                .get(0);
        final var book = bookRepository
                .findAll()
                .get(0);
        rentalRepository.save(
                Rental.builder()
                        .member(member)
                        .book(book)
                        .bookRented(OffsetDateTime.now())
                        .updated(OffsetDateTime.now())
                        .build()
        );
    }
}

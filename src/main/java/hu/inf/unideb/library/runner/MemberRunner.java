package hu.inf.unideb.library.runner;

import com.github.javafaker.Faker;
import hu.inf.unideb.library.model.Member;
import hu.inf.unideb.library.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
@Order(1)
public class MemberRunner implements CommandLineRunner {

    private static final Faker FAKER = new Faker();
    private final MemberRepository repository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(
                    repository.save(
                            Member.builder()
                                    .libraryCardNumber(FAKER.number().numberBetween(1,9999))
                                    .name(FAKER.hobbit().character())
                                    .email((FAKER.internet().emailAddress()))
                                    .memberSince(OffsetDateTime.now())
                                    .updated(OffsetDateTime.now())
                                    .build()
                    )
            );
        }
    }
}

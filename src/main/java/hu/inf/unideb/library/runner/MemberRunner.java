package hu.inf.unideb.library.runner;

import com.github.javafaker.Faker;
import hu.inf.unideb.library.model.Member;
import hu.inf.unideb.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class MemberRunner implements CommandLineRunner {

    private static final Faker FAKER = new Faker();
    private final MemberRepository repository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(
                    repository.save(
                            Member.builder()
                                    .libraryCardNumber(FAKER.number().numberBetween(1,9999))
                                    .name(FAKER.hobbit().character())
                                    .email((FAKER.pokemon().name()).toLowerCase() + "@gmail.com")
                                    .memberSince(OffsetDateTime.now())
                                    .updated(OffsetDateTime.now())
                                    .build()
                    )
            );
        }
    }
}

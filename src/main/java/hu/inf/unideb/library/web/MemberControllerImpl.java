package hu.inf.unideb.library.web;

import com.github.javafaker.Faker;
import hu.inf.unideb.library.model.Member;
import hu.inf.unideb.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberControllerImpl implements MemberController{

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberControllerImpl.class);
    private final MemberRepository repository;
    private static final Faker FAKER = new Faker();

    @Override
    public Member getOne(Integer libraryCardNumber) {
        LOGGER.info("getOne({})", libraryCardNumber);

        return repository.
                findById(libraryCardNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A tag nem található ezzel a számmal: " + libraryCardNumber));
    }

    @Override
    public List<Member> getAll() {
        LOGGER.info("getAll()");

        return repository.findAll();
    }

    @Override
    public Member createOne(Member member) {
        LOGGER.info("createOne({})", member);

        return repository.save(member.withLibraryCardNumber(FAKER.number().numberBetween(1,9999)))
                .withMemberSince(OffsetDateTime.now())
                .withUpdated(OffsetDateTime.now());
    }

    @Override
    public Member updateOne(Member member) {
        LOGGER.info("updateOne({})", member);

        return Optional.of(member)
                .map(Member::getLibraryCardNumber)
                .flatMap(repository::findById)
                .map(m -> {
                    m.setName(member.getName());
                    m.setEmail(m.getEmail());
                    m.setUpdated(OffsetDateTime.now());
                    return m;
                })
                .map(repository::save)
                .orElseThrow();
    }

    @Override
    public void deleteOne(Integer libraryCardNumber) {
        LOGGER.info("deleteOne({})", libraryCardNumber);
        try {
            repository.deleteById(libraryCardNumber);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A könytár taghoz kölcsönzés tartozik, ezért nem törölhető!");
        }

    }
}

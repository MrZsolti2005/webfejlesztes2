package hu.inf.unideb.library.web;

import hu.inf.unideb.library.model.Rental;
import hu.inf.unideb.library.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RentalControllerImpl implements RentalController{

    private static final Logger LOGGER = LoggerFactory.getLogger(RentalControllerImpl.class);
    private final RentalRepository repository;

    @Override
    public Rental getOne(UUID rentalId) {
        LOGGER.info("getOne({})", rentalId);

        return repository.
                findById(rentalId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A tag nem található ezzel a számmal: " + rentalId));
    }

    @Override
    public List<Rental> getAll() {
        LOGGER.info("getAll()");

        return repository.findAll();
    }

    @Override
    public Rental createOne(Rental rental) {
        LOGGER.info("createOne({})", rental);

        return repository.save(rental.withId(null))
                .withBookRented(OffsetDateTime.now())
                .withUpdated(OffsetDateTime.now());
    }

    @Override
    public Rental updateOne(Rental rental) {
        LOGGER.info("updateOne({})", rental);

        return Optional.of(rental)
                .map(Rental::getId)
                .flatMap(repository::findById)
                .map(r -> {
                    r.setBook(rental.getBook());
                    r.setMember(rental.getMember());
                    r.setStarReview(rental.getStarReview());
                    r.setUpdated(OffsetDateTime.now());
                    return r;
                })
                .map(repository::save)
                .orElseThrow();
    }

    @Override
    public void deleteOne(UUID rentalId) {
        LOGGER.info("deleteOne({})", rentalId);
        repository.deleteById(rentalId);
    }
}

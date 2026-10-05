package hu.inf.unideb.library.repository;

import hu.inf.unideb.library.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RentalRepository extends JpaRepository<Rental, UUID> {
}

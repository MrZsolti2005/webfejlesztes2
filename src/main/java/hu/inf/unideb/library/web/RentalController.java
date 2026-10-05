package hu.inf.unideb.library.web;

import hu.inf.unideb.library.model.Rental;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface RentalController {

        @RequestMapping(
                path = "api/library/rentals/{rentalId}",
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE
        )
        Rental getOne(
                @PathVariable UUID rentalId
                );

        @GetMapping("api/library/rentals")
        List<Rental> getAll();

        @PostMapping("api/library/rentals")
        Rental createOne(
                @RequestBody Rental rental
                );

        @PutMapping("/api/library/rentals")
        Rental updateOne(
                @RequestBody Rental rental
        );

        @DeleteMapping("/api/library/rentals/{rentalId}")
        void deleteOne(
                @PathVariable UUID rentalId
        );

}

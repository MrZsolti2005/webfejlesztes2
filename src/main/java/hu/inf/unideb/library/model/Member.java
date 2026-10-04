package hu.inf.unideb.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Member {
    @Id
    @NonNull
    @EqualsAndHashCode.Include
    int libraryCardNumber;
    String name;
    String email;
    OffsetDateTime memberSince;
    OffsetDateTime updated;
}

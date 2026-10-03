package hu.inf.unideb.library.model;

import lombok.*;

import java.time.OffsetDateTime;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@With
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Member {
    @EqualsAndHashCode.Include
    int libraryCardNumber;
    String name;
    String email;
    OffsetDateTime memberSince;
    OffsetDateTime updated;
}

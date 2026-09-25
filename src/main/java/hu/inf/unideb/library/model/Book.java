package hu.inf.unideb.library.model;

import lombok.*;

import java.time.OffsetDateTime;
import java.time.Year;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@With
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
    String  isbn;
    String title;
    String author;
    Genre genre;
    Year year;
    int pageCount;
    OffsetDateTime created;
    OffsetDateTime updated;

    public enum Genre{
        KRIMI,
        THRILLER,
        ROMANTIKUS,
        SCIFI,
        FANTASY
    };
}

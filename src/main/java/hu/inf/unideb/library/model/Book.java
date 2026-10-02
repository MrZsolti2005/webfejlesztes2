package hu.inf.unideb.library.model;

import lombok.*;

import java.time.OffsetDateTime;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@With
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
    @NonNull
    @EqualsAndHashCode.Include
    String  isbn;
    String title;
    String author;
    Genre genre;
    String publisher;
    int year;
    int pageCount;
    OffsetDateTime created;
    OffsetDateTime updated;

    public enum Genre{
        KRIMI,
        THRILLER,
        ROMANTIKUS,
        SCIFI,
        FANTASY
    }
}

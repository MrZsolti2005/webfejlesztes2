package hu.inf.unideb.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Book {
    @Id
    @NonNull
    @EqualsAndHashCode.Include
    private String  isbn;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String publisher;
    private int publicationYear;
    private int pageCount;
    private OffsetDateTime created;
    private OffsetDateTime updated;

    public enum Genre{
        KRIMI,
        THRILLER,
        ROMANTIKUS,
        SCIFI,
        FANTASY
    }
}

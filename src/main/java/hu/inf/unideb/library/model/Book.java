package hu.inf.unideb.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Random;

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
        FANTASY;

        private static final Random RANDOM = new Random();

        public static Genre next() {
            return values()[RANDOM.nextInt(values().length)];
        }
    }
}

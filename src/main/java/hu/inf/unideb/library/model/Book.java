package hu.inf.unideb.library.model;

import java.time.OffsetDateTime;
import java.time.Year;

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

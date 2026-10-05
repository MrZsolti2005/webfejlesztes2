package hu.inf.unideb.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Rental {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
    private Integer starReview;
    private OffsetDateTime bookRented;
    private OffsetDateTime updated;
}

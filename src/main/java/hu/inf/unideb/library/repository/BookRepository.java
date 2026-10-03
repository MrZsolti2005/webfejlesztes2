package hu.inf.unideb.library.repository;

import hu.inf.unideb.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, String> {

}

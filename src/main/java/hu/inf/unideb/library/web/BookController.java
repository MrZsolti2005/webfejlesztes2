package hu.inf.unideb.library.web;

import hu.inf.unideb.library.model.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BookController {

    @RequestMapping(
            path = "api/library/books/{isbn}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    Book getOne(
            @PathVariable String isbn
    );

    @GetMapping("api/library/books")
    List<Book> getAll();

    @PostMapping("api/library/books")
    Book createOne(
            @RequestBody Book book
    );

    @PutMapping("/api/library/books")
    Book updateOne(
            @RequestBody Book book
    );

    @DeleteMapping("/api/library/books/{isbn}")
    void deleteOne(
            @PathVariable String isbn
    );
}

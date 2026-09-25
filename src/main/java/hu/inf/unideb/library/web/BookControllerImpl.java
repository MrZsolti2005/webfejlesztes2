package hu.inf.unideb.library.web;

import hu.inf.unideb.library.model.Book;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController{

    private static final Logger LOGGER = LoggerFactory.getLogger(BookControllerImpl.class);

    @Override
    public Book getOne(String isbn) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }

    @Override
    public Book createOne(Book book) {
        return null;
    }

    @Override
    public Book updateOne(Book book) {
        return null;
    }

    @Override
    public void deleteOne(String isbn) {

    }
}

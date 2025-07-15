package az.edu.turing.bookauthor.service;

import az.edu.turing.bookauthor.model.Book;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface BookService {


    Book createBook(Book book);
    Book updateBook(Long id,Book updatedBook);
    Optional<Book> findById(Long id);
    List<Book> getAllBooks();
    void deleteBook(Long id);
    





}

package az.edu.turing.bookauthor.service;

import az.edu.turing.bookauthor.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AuthorService {

    Author createAuthor(Author author);
    Author updateAuthor(Long id,Author updatedAuthor);
    void deleteAuthor(Long id);
    List<Author> getAllAuthors();
    Optional<Author> findById(Long id);





}

package az.edu.turing.bookauthor.service;

import az.edu.turing.bookauthor.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorService {

    Author createAuthor(Author author);
    Author updateAuthor(Long id,Author updatedAuthor);
    void deleteAuthor(Long id);
    List<Author> getAllAuthors(Author author);
    Author findById(Long id);





}

package az.edu.turing.bookauthor.service;

import az.edu.turing.bookauthor.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {


    Book createBook(Book book);
    Book updateBook(Long id,Book updatedBook);
    Book findById(Long id);
    List<Book> getAllBooks(Book book);
    void deleteBook(Long id);
    





}

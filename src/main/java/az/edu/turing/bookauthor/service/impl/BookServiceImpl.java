package az.edu.turing.bookauthor.service.impl;

import az.edu.turing.bookauthor.exceptions.ResourceNotFoundException;
import az.edu.turing.bookauthor.model.Book;
import az.edu.turing.bookauthor.repository.BookRepository;
import az.edu.turing.bookauthor.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    public final BookRepository bookRepository;


    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setAuthor(updatedBook.getAuthor());
                    existingBook.setIsbn(updatedBook.getIsbn());
                    existingBook.setTitle(updatedBook.getTitle());
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }
}

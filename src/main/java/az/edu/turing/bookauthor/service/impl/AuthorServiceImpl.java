package az.edu.turing.bookauthor.service.impl;

import az.edu.turing.bookauthor.model.Author;
import az.edu.turing.bookauthor.repository.AuthorRepository;
import az.edu.turing.bookauthor.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {

        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author updatedAuthor) {
       return authorRepository.findById(id)
                .map(existingAuthor -> {
                    existingAuthor.setName(updatedAuthor.getName());
                    existingAuthor.setEmail(updatedAuthor.getEmail());
                    existingAuthor.setBooks(updatedAuthor.getBooks());
                    return authorRepository.save(existingAuthor);
                })
                .orElse(null); // Or throw new EntityNotFoundException
    }

    @Override
    public void deleteAuthor(Long id) {

    }

    @Override
    public List<Author> getAllAuthors(Author author) {
        return List.of();
    }

    @Override
    public Author findById(Long id) {
        return null;
    }
}

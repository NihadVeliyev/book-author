package az.edu.turing.bookauthor.controller;

import az.edu.turing.bookauthor.exceptions.ResourceNotFoundException;
import az.edu.turing.bookauthor.model.Author;
import az.edu.turing.bookauthor.service.AuthorService;
import az.edu.turing.bookauthor.service.impl.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthorController {

    public final AuthorService authorService;
    private final AuthorServiceImpl authorServiceImpl;


    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return authorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/authors/{id")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        Author existingAuthor = authorService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author  not found with id:" + id));
        existingAuthor.setBooks(updatedAuthor.getBooks());
        existingAuthor.setEmail(updatedAuthor.getEmail());
        existingAuthor.setName(updatedAuthor.getName());
        Author savedAuthor = authorService.createAuthor(existingAuthor);
        return ResponseEntity.ok(savedAuthor);
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author createdAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(201).body(createdAuthor);
    }



}



package az.edu.turing.bookauthor.controller;


import az.edu.turing.bookauthor.exceptions.ResourceNotFoundException;
import az.edu.turing.bookauthor.model.Book;
import az.edu.turing.bookauthor.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraintvalidators.RegexpURLValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {
    public final BookService bookService;
    private final RegexpURLValidator regexpURLValidator;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return bookService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book createdBook=bookService.createBook(book);
        return ResponseEntity.status(201).body(createdBook);


    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            @RequestBody Book updatedBook) {

        Book savedBook = bookService.updateBook(id, updatedBook);
        return ResponseEntity.ok(savedBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();

    }





}

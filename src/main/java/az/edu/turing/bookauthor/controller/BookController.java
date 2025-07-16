package az.edu.turing.bookauthor.controller;


import az.edu.turing.bookauthor.model.Book;
import az.edu.turing.bookauthor.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {
    public final BookService bookService;

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




}

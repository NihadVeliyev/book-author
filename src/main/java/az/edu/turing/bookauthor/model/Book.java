package az.edu.turing.bookauthor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private  String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}


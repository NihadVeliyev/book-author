package az.edu.turing.bookauthor.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private  String email;

    @OneToMany(mappedBy = "author")
    private List<Book> books; // one author → many books

}

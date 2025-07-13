package az.edu.turing.bookauthor.repository;

import az.edu.turing.bookauthor.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}

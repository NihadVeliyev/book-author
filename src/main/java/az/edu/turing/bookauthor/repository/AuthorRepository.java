package az.edu.turing.bookauthor.repository;

import az.edu.turing.bookauthor.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}

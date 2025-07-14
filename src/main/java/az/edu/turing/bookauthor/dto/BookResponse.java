package az.edu.turing.bookauthor.dto;

import az.edu.turing.bookauthor.model.Author;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookResponse {
    private Long id;

    private String title;

    private  String isbn;

    private AuthorResponse author;
}

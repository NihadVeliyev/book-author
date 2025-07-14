package az.edu.turing.bookauthor.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorResponse {
    private Long id;

    private String name;

    private  String email;

    private BookResponse book;
}

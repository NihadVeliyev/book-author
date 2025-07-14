package az.edu.turing.bookauthor.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorRequest {
    private String name;

    private  String email;
    private BookRequest book;
}

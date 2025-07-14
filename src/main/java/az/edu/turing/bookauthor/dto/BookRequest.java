package az.edu.turing.bookauthor.dto;

import lombok.Builder;
import lombok.Data;

@Data

@Builder
public class BookRequest {


    private String title;

    private  String isbn;
    private AuthorRequest author;

}

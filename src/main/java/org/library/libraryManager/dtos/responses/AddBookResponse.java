package org.library.libraryManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class AddBookResponse {
    @Id
    private String id;
    private String title;
    private String author;
    private String yearOfPublication;
    private String isbn;
    private String message;
}

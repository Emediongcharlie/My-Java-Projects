package org.library.libraryManager.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    @Id
    private String bookId;
    private String readerId;
    private String title;
    private String author;
    private String yearOfPublication;
    private String isbn;
}

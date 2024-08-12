package org.library.libraryManager.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class BookLending {

    @Id
    private String bookId;
    private String readerId;
    private String title;
    private String author;
    private int yearOfPublication;
    private BookStatus status;
    private String dateCollected;
    private String dateToReturn;
}

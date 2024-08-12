package org.library.libraryManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.library.libraryManager.data.models.BookStatus;

@Getter
@Setter
public class LendBookResponse {

    private String bookId;
    private String readerId;
    private String title;
    private String author;
    private int yearOfPublication;
    private BookStatus status;
    private String dateCollected;
    private String dateToReturn;
    private String message;
}

package org.library.libraryManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.library.libraryManager.data.models.BookStatus;

@Getter
@Setter
public class LendBookRequest {

    private String bookId;
    private String readerId;
    private String username;
    private String title;
    private String author;
    private int yearOfPublication;
    private BookStatus status;
    private String dateCollected;
    private String dateToReturn;
}

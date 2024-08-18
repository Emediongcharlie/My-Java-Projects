package org.library.libraryManager.dtos.requests;

import lombok.Data;

@Data
public class AddBookRequest {

//    private String bookId;
    private String author;
    private String title;
    private String yearOfPublication;
    private String isbn;
    private String username;
    private String password;


}

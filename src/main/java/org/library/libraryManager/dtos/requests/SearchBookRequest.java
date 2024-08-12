package org.library.libraryManager.dtos.requests;

import lombok.Data;

@Data
public class SearchBookRequest {
    private String title;
    private String author;
    private String isbn;
    private String id;
}

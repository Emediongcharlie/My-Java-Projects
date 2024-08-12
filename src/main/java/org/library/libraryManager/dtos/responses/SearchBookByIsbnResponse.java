package org.library.libraryManager.dtos.responses;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchBookByIsbnResponse {

    private String title;
    private String author;
    private String isbn;
    private String YearOfPublication;
}

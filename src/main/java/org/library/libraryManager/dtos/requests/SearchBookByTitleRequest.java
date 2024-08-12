package org.library.libraryManager.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchBookByTitleRequest {

    private String title;
    private String author;
    private String isbn;
    private String YearOfPublication;
}

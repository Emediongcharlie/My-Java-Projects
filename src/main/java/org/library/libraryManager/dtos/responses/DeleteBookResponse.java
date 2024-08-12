package org.library.libraryManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBookResponse {
    private String title;
    private String message;
}

package org.library.libraryManager.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class libraryApiResponse {
    private boolean isSuccessful;
    private Object data;
}

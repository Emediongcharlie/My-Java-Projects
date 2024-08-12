package org.library.libraryManager.dtos.requests;

import lombok.Data;

@Data
public class ReadersLoginRequest {

    private String username;
    private String password;

}

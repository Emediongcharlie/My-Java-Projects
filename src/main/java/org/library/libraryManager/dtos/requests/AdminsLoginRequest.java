package org.library.libraryManager.dtos.requests;

import lombok.Data;

@Data
public class AdminsLoginRequest {


    private String username;
    private String password;
}

package org.library.libraryManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class AdminsRegistrationResponse {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String message;
}

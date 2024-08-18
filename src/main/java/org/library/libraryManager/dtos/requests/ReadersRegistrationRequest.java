package org.library.libraryManager.dtos.requests;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ReadersRegistrationRequest {

    @Id
    private String readerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private String phoneNumber;

}

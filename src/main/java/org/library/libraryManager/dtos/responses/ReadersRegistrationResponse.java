package org.library.libraryManager.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class ReadersRegistrationResponse {

    @Id
    private String readerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    private String phoneNumber;
    private String message;
}

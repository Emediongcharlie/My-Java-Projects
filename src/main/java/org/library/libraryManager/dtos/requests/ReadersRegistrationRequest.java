package org.library.libraryManager.dtos.requests;

import lombok.Data;

@Data
public class ReadersRegistrationRequest {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    private String phoneNumber;

}

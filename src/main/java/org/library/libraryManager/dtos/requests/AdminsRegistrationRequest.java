package org.library.libraryManager.dtos.requests;

import lombok.Data;
import org.library.libraryManager.data.models.ClassOfUser;

@Data
public class AdminsRegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String Username;
    private ClassOfUser classOfUser;
}

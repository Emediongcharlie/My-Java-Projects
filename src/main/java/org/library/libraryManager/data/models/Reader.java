package org.library.libraryManager.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Reader {

    @Id
    private String readerId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String username;
    private String phoneNumber;
    private ClassOfUser classOfUser;
    private RegistrationStatus registrationStatus;



//    public void setUsername(String username){
//
//    }
}

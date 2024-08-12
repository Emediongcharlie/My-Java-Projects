package org.library.libraryManager.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Librarian {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String Username;
    private String email;
    private ClassOfUser classOfUser;

//    @DBRef
//    private Book books;
//
//    @DBRef
//    private Reader users;

//    public void setUsername(String username) {
//        this.firstName = username;
//    }
}

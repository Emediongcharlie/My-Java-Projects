package org.library.libraryManager.data.repositories;

import org.library.libraryManager.data.models.ClassOfUser;
import org.library.libraryManager.data.models.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LibrarianRepository extends MongoRepository<Librarian, String> {

    Optional<Librarian> findByUsername(String username);

//    Optional<Librarian> findByUsernameAndPassword(String username, String password);
    Librarian findByUsernameAndPassword(String username, String password);

    Librarian findByPassword(String password);

    Librarian findLibrarianByClassOfUser(ClassOfUser classOfUser);

}

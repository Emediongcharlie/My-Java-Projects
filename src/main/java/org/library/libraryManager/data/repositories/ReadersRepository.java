package org.library.libraryManager.data.repositories;

import org.library.libraryManager.data.models.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReadersRepository extends MongoRepository<Reader, String> {
    Reader findByEmail(String email);
    Reader findByUsername(String username);
    Optional<Reader> findByUsernameAndPassword(String username, String password);


}

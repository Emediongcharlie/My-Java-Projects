package org.library.libraryManager.data.repositories;

import org.library.libraryManager.data.models.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibrarianRepository extends MongoRepository<Librarian, String> {
}

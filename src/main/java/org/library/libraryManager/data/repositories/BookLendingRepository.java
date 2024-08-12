package org.library.libraryManager.data.repositories;

import org.library.libraryManager.data.models.BookLending;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookLendingRepository extends MongoRepository<BookLending, String> {

    BookLending findByTitle(String title);
}

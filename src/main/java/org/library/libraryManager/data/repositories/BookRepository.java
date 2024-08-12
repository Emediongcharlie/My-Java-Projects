package org.library.libraryManager.data.repositories;

import org.library.libraryManager.data.models.Book;
import org.library.libraryManager.data.models.BookStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface BookRepository extends MongoRepository<Book, String> {

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByTitle(String title);
    Book findByYearOfPublication(String yearOfPublication);
//    Book findByTitle(String title);
    boolean existsByTitle(String title);
    Optional<Book> existsByStatus(BookStatus status);

}

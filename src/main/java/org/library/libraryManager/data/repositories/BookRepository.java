package org.library.libraryManager.data.repositories;

import org.library.libraryManager.data.models.Book;
import org.library.libraryManager.data.models.BookStatus;
import org.library.libraryManager.data.models.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface BookRepository extends MongoRepository<Book, String> {

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByTitle(String title);

    boolean existsByTitle(String title);

    Book findByUsername(String username);

    Optional<Book> findByAuthor(String author);


}

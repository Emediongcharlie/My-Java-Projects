package org.library.libraryManager.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.libraryManager.data.models.Book;
import org.library.libraryManager.data.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
    }
    @Test
    public void testTitle() {
        Book book = new Book();
        book.setTitle("title");
        var response = bookRepository.save(book);
        assertEquals(response.getTitle().contains("title"), true);

    }
}

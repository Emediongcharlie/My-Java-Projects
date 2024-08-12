package org.library.libraryManager.services;


import org.library.libraryManager.data.models.Book;
import org.library.libraryManager.dtos.requests.*;
import org.library.libraryManager.dtos.responses.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryServices {
    AddBookResponse addBook(AddBookRequest request);
    AdminsRegistrationResponse adminsRegistration(AdminsRegistrationRequest request);
    AdminsLoginResponse adminsLogin(AdminsLoginRequest request);
    ReadersRegistrationResponse newReadersRegistration(ReadersRegistrationRequest request);
    ReadersLoginResponse readerLogin(ReadersLoginRequest request);
    SearchBookResponse searchAllBook(SearchBookRequest request);

    DeleteBookResponse deleteAllBook();
    LendBookResponse lendBook(LendBookRequest request, String title);

    Book readBookByTitle(String title);

    List<Book> readBooks();

    Book readBookByIsbn(String isbn);

    int count();
}

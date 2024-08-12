package org.library.libraryManager.services;

import lombok.RequiredArgsConstructor;
import org.library.libraryManager.data.models.*;
import org.library.libraryManager.data.repositories.BookLendingRepository;
import org.library.libraryManager.data.repositories.BookRepository;
import org.library.libraryManager.data.repositories.LibrarianRepository;
import org.library.libraryManager.data.repositories.ReadersRepository;
import org.library.libraryManager.dtos.requests.*;
import org.library.libraryManager.dtos.responses.*;
import org.library.libraryManager.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.library.libraryManager.data.models.ClassOfUser.ADMIN;

@Service
@RequiredArgsConstructor
public class LibraryServicesImpl implements LibraryServices {

    @Autowired
    public final BookRepository bookRepository;
    @Autowired
    public final LibrarianRepository librarianRepository;
    @Autowired
    public final ReadersRepository readerRepository;
    @Autowired
    public final BookLendingRepository bookLendingRepository;

    int counter = 0;

    @Override
    public AddBookResponse addBook(AddBookRequest request) {
        Book book = new Book();
        boolean titleExists = bookRepository.existsByTitle(request.getTitle());
        if (titleExists) {
            throw new TitleAlreadyExistException("title exists already");
        } else {
            AddBookResponse response = new AddBookResponse();
            book.setAuthor(request.getAuthor());
            book.setTitle(request.getTitle());
            book.setYearOfPublication(request.getYearOfPublication());
            book.setIsbn(request.getIsbn());
            bookRepository.save(book);
            response.setId(book.getBookId());
            response.setTitle(book.getTitle());
            response.setAuthor(book.getAuthor());
            response.setYearOfPublication(book.getYearOfPublication());
            response.setIsbn(book.getIsbn());
            response.setMessage("Successfully added book");
            counter++;
            return response;
        }
    }

    @Override
    public AdminsRegistrationResponse adminsRegistration(AdminsRegistrationRequest request) {
        Librarian librarian = new Librarian();
        AdminsRegistrationResponse response = new AdminsRegistrationResponse();
        validateUserNameExist(request.getUsername());
        librarian.setClassOfUser(ADMIN);
        librarian.setFirstName(request.getFirstName());
        librarian.setLastName(request.getLastName());
        librarian.setUsername(request.getUsername());
        librarian.setPassword(request.getPassword());
        librarian.setEmail(request.getEmail());
        librarianRepository.save(librarian);
        response.setFirstName(librarian.getFirstName());
        response.setLastName(librarian.getLastName());
        response.setPassword(librarian.getPassword());
        response.setEmail(librarian.getEmail());
        response.setMessage("Successfully registered admin");
        return response;
    }

    @Override
    public AdminsLoginResponse adminsLogin(AdminsLoginRequest request) {
        AdminsLoginResponse response = new AdminsLoginResponse();
        Librarian librarian = new Librarian();
        validateUserName(request.getUsername());
        librarian.setUsername(request.getUsername());
        librarian.setPassword(request.getPassword());
        librarianRepository.save(librarian);
        response.setMessage("Successfully logged in");
        return response;
    }

    @Override
    public ReadersRegistrationResponse newReadersRegistration(ReadersRegistrationRequest request) {
        validateEmail(request.getEmail());
        Reader reader = new Reader();
        reader.setFirstName(request.getFirstName());
        reader.setLastName(request.getLastName());
        reader.setPassword(request.getPassword());
        reader.setUsername(request.getUserName());
        reader.setEmail(request.getEmail());
        readerRepository.save(reader);
        ReadersRegistrationResponse response = new ReadersRegistrationResponse();
        response.setFirstName(reader.getFirstName());
        response.setLastName(reader.getLastName());
        response.setPassword(reader.getPassword());
        response.setEmail(reader.getEmail());
        response.setPhoneNumber(reader.getPhoneNumber());
        response.setMessage("Successfully registered new reader");

        return response;
    }

    @Override
    public ReadersLoginResponse readerLogin(ReadersLoginRequest request) {
        validateUserName(request.getUsername());
        Reader reader = new Reader();
        ReadersLoginResponse response = new ReadersLoginResponse();
        response.setMessage("Successfully logged in");
        return response;
    }

    @Override
    public SearchBookResponse searchAllBook(SearchBookRequest request) {
        Book book = new Book();
        bookRepository.findAll();
        SearchBookResponse response = new SearchBookResponse();
        response.setMessage("Successfully searched books");
        return response;
    }

    @Override
    public DeleteBookResponse deleteAllBook() {
        DeleteBookResponse response = new DeleteBookResponse();
        bookRepository.deleteAll();
        response.setMessage("Successfully deleted");
        counter--;
        return response;
    }

    @Override
    public LendBookResponse lendBook(LendBookRequest request, String title) {
        BookLending bookLending = new BookLending();
        Reader reader = new Reader();
        Optional<Book> titleExists = bookRepository.findByTitle(title);
        if (titleExists.isPresent()) {
            bookLending.setTitle(request.getTitle());
            bookLending.setAuthor(request.getAuthor());
            bookLending.setYearOfPublication(request.getYearOfPublication());
            Reader read = validateUserName(request.getUsername());
            reader.setFirstName(read.getFirstName());
            reader.setLastName(read.getLastName());
            reader.setPassword(read.getPassword());
            bookLendingRepository.save(bookLending);
        }
//        if (request.getStatus() == BookStatus.AVAILABLE){
//            bookLending.setTitle(request.getTitle());
//            bookLending.setAuthor(request.getAuthor());
//            bookLending.setYearOfPublication(request.getYearOfPublication());
//            bookLending.setDateCollected(request.getDateCollected());
//            bookLending.setDateToReturn(request.getDateToReturn());
//            bookLendingRepository.save(bookLending);
//            LendBookResponse response = new LendBookResponse();
//            response.setTitle(bookLending.getTitle());
//            response.setAuthor(bookLending.getAuthor());
//            response.setYearOfPublication(bookLending.getYearOfPublication());
//            response.setDateCollected(bookLending.getDateToReturn());
//            response.setDateToReturn(bookLending.getDateCollected());
//            response.setMessage("Successfully lent book");
//            return response;
//        }
//        throw new EntityNotFoundException("Book not available");
    }


    @Override
    public Book readBookByTitle(String title) {
//        Book book = new Book();
//        return bookRepository.findByTitle(title)
//                .orElseThrow(()-> new FindByTitleException("title not found"));
        Optional<Book> book = bookRepository.findByTitle(title);
        if (book.isPresent()) {
            book.get();
        }
        return book.orElse(null);
    }

    public Book readBookByIsbn(String isbn) {
        Optional<Book> books = bookRepository.findByIsbn(isbn);
        if (books.isPresent()) {
            books.get().setIsbn(isbn);
        }
        return books.orElse(null);
    }

    @Override
    public List<Book> readBooks() {
        ReadBooksResponse response = new ReadBooksResponse();
        response.setMessage("Books Accessed");
        return bookRepository.findAll();
    }

    private void validateEmail(String email) {
        Reader readerEmail = readerRepository.findByEmail(email);
        if (readerEmail != null) {
            throw new EmailExistAlreadyException(String.format("%s already exist",email));
        }
    }

    private Reader validateUserName(String userName) {
        Reader readerUsername = readerRepository.findByUsername(userName);
        if(readerUsername != null) {
            throw new UsernameAlreadyExistException("Username Exist");
        }

        return readerUsername;
    }

    private void validateUserNameExist(String userName) {
        Reader readerUsername = readerRepository.findByUsername(userName);
        if(readerUsername == null) {
            throw new UsernameAlreadyExistException("Username Exist");
        }

    }

    public  int count(){
        return counter++;
    }

}
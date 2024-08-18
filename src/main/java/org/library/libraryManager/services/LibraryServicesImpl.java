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
    //  @Lazy
    public final BookRepository bookRepository;
    @Autowired
    //   @Lazy
    public final LibrarianRepository librarianRepository;
    @Autowired
//    @Lazy
    public final ReadersRepository readerRepository;
    @Autowired
    // @Lazy
    public final BookLendingRepository bookLendingRepository;

    int counter = 0;


    @Override
    public AddBookResponse addBook(AddBookRequest request) {
        Book book = new Book();

        validateLogin(request.getUsername());
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
            return response;
        }
    }

    private void validateUserLogin(String username) {
        Optional<Librarian> librarianOptional = librarianRepository.findByUsername(username);
//        Librarian librarianValid = librarianRepository.findByUsername(username);
        if (!librarianOptional.isPresent()) {
            throw new EntityNotFoundException("user does not exist");
        }
    }

    private void validateLogin(String username) {
        Book bookLogin = bookRepository.findByUsername(username);
        if (bookLogin != null) {
            throw new EntityNotFoundException("Already logged in");
        }
    }

    @Override
    public AdminsRegistrationResponse adminsRegistration(AdminsRegistrationRequest request) {
        Librarian librarian = new Librarian();
        AdminsRegistrationResponse response = new AdminsRegistrationResponse();
        validateAdminRegisterUserName(request.getUsername());
        librarian.setClassOfUser(ADMIN);
        librarian.setFirstName(request.getFirstName());
        librarian.setLastName(request.getLastName());
        librarian.setUsername(request.getUsername());
        librarian.setPassword(request.getPassword());
        librarian.setEmail(request.getEmail());
        librarianRepository.save(librarian);
        response.setId(librarian.getId());
        response.setFirstName(librarian.getFirstName());
        response.setLastName(librarian.getLastName());
        response.setPassword(librarian.getPassword());
        response.setEmail(librarian.getEmail());
        response.setMessage("Successfully registered admin");
        return response;
    }

    @Override
    public AdminsLoginResponse adminsLogin(AdminsLoginRequest request) {
//        statusCheck(ClassOfUser.ADMIN);
        AdminsLoginResponse response = new AdminsLoginResponse();
        Librarian librarian = new Librarian();
        validateAdminLoginUsernameAndPassword(request.getUsername(), request.getPassword());
        librarian.setUsername(request.getUsername());
        librarian.setPassword(request.getPassword());
        librarianRepository.save(librarian);
        response.setMessage("Successfully logged in");
        return response;
    }

    private void statusCheck(ClassOfUser classOfUser){
        Librarian librarian = librarianRepository.findLibrarianByClassOfUser(ClassOfUser.ADMIN);
        if(!librarian.getClassOfUser().equals(ADMIN)){
            throw new EntityNotFoundException("User not a Librarian");
        }
    }
    @Override
    public ReadersRegistrationResponse newReadersRegistration(ReadersRegistrationRequest request) {
        validateUserRegEmail(request.getEmail());
        Reader reader = new Reader();

        reader.setFirstName(request.getFirstName());
        reader.setLastName(request.getLastName());
        reader.setPassword(request.getPassword());
        reader.setUsername(request.getUsername());
        reader.setPhoneNumber(request.getPhoneNumber());
        reader.setEmail(request.getEmail());
        readerRepository.save(reader);
        ReadersRegistrationResponse response = new ReadersRegistrationResponse();
        response.setReaderId(reader.getReaderId());
        response.setFirstName(reader.getFirstName());
        response.setLastName(reader.getLastName());
        response.setPassword(reader.getPassword());
        response.setUserName((reader.getUsername()));
        response.setEmail(reader.getEmail());
        response.setPhoneNumber(reader.getPhoneNumber());
        response.setMessage("Successfully registered new reader");

        return response;
    }

    @Override
    public ReadersLoginResponse readerLogin(ReadersLoginRequest request) {
        validateUserNameAndPassword(request.getUsername(), request.getPassword());
        Reader reader = new Reader();
        reader.setUsername(request.getUsername());
        reader.setPassword(request.getPassword());
        readerRepository.save(reader);
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
    public Reader lendBook(LendBookRequest request, String title) {
//        BookLending bookLending = new BookLending();
//        Reader reader = new Reader();
//        Optional<Book> titleExists = bookRepository.findByTitle(title);
//        if (titleExists.isPresent()) {
//            bookLending.setTitle(request.getTitle());
//            bookLending.setAuthor(request.getAuthor());
//            bookLending.setYearOfPublication(request.getYearOfPublication());
//            Reader read = validateUserName(request.getUsername());
//            read.setFirstName(request.getFirstName());
//            read.setLastName(request.getLastName());
//            rea.setPassword(read.getPassword());
//            readerRepository.save()
//        }
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
        Optional<Book> bookToLend = bookRepository.findByTitle(title);
        if (bookToLend.isPresent()) {
            Book bookLending = bookToLend.get();
            bookLending.setTitle(request.getTitle());
            bookLending.setAuthor(request.getAuthor());
            bookLending.setUsername(request.getUsername());
            bookLending.setYearOfPublication(request.getYearOfPublication());
            bookRepository.save(bookLending);
            Reader response = readerRepository.findByUsername(request.getUsername());
            response.setUsername(bookLending.getUsername());
            LendBookResponse lendBookResponse = new LendBookResponse();
            lendBookResponse.setMessage("Successfully lent book");
            return response;
        }
        throw new EntityNotFoundException("no book to lend");
    }


    @Override
    public Book readBookByTitle(String title) {

//        Book book = new Book();
//        return bookRepository.findByTitle(title)
//                .orElseThrow(()-> new FindByTitleException("title not found"));
        Optional<Book> book = bookRepository.findByTitle(title);
        if (book.isPresent()) {
            return book.get();
        }
        return book.orElse(null);
    }

    public SearchBookByAuthorResponse readBookByAuthor(String author) {
        Optional<Book> books = bookRepository.findByAuthor(author);
        if (books.isPresent()) {
//            books.get().setAuthor(author);
//            books.get().setTitle(author);
//            books.get().setYearOfPublication(author);
//            SearchBookByAuthorResponse response = new SearchBookByAuthorResponse();
//            response.setAuthor(books.get().getAuthor());
//            response.setTitle(books.get().getTitle());
//            response.setYearOfPublication(books.get().getYearOfPublication());
//            response.setMessage("Successfully searched book by author");
//            return response;

           books.get();
        }
        throw new EntityNotFoundException("Book not found");
//        return books.orElse(null);
    }

    @Override
    public List<Book> readBooks() {
        ReadBooksResponse response = new ReadBooksResponse();
        response.setMessage("Books Accessed");
        return bookRepository.findAll();
    }

        private void validateUserRegEmail(String email) {
        Reader readerEmail = readerRepository.findByEmail(email);
        if (readerEmail != null) {
            throw new EmailExistAlreadyException(String.format("%s already exist", email));
        }
    }

    private void validateUserNameAndPassword(String username, String password){
        Optional <Reader> readerOptional = readerRepository.findByUsernameAndPassword(username, password);
        if(!readerOptional.isPresent()){
            throw new EntityNotFoundException("username not found, register pls");
        }
    }

    private void validateAdminLoginUsernameAndPassword(String username, String password){
//        Optional<Librarian> librarianOptional = librarianRepository.findByUsernameAndPassword(username, password);
//        if(!librarianOptional.isPresent()){
//            throw new EntityNotFoundException("username not found, register pls");
//        }
        Librarian librarianLogin = librarianRepository.findByUsernameAndPassword(username, password);
            if(!librarianLogin.getUsername().equals(username) || !librarianLogin.getPassword().equals(password)){
                throw new EntityNotFoundException("username or password incorrect");
            }
        }


    private void validateAdminRegisterUserName(String password) {
//        Optional<Librarian> readerRegUsername = librarianRepository.findByUsername(userName);
//        if (readerRegUsername.isPresent()) {
//            throw new UsernameAlreadyExistException("Username exist");
//        }
        Librarian librarianReg = librarianRepository.findByPassword(password);
        if(librarianReg != null){
            throw new EntityNotFoundException("username exist");
        }
        }
//    private void validateUserNameExist(String userName) {
//        Reader readerUsername = readerRepository.findByUsername(userName);
//        if(readerUsername != null) {
//            throw new UsernameAlreadyExistException("Username Exist");
//        }
//
//    }

    private void validateAuthor(String author){
        Optional<Book> book = bookRepository.findByAuthor(author);
        if(!book.isPresent()){
            throw new EntityNotFoundException("author not found");
        }
    }
    }

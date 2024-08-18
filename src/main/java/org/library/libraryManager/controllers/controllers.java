package org.library.libraryManager.controllers;

import lombok.RequiredArgsConstructor;
import org.library.libraryManager.data.models.Book;
import org.library.libraryManager.data.models.Reader;
import org.library.libraryManager.dtos.requests.*;
import org.library.libraryManager.dtos.responses.*;
import org.library.libraryManager.services.LibraryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class controllers {


    private  final LibraryServices libraryServices;

    @PostMapping("/add-books")
    public ResponseEntity <?> addBooks(@RequestBody AddBookRequest addBookRequest) {
        try {
            AddBookResponse response = libraryServices.addBook(addBookRequest);
            return new ResponseEntity<>(new libraryApiResponse(true, response), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new libraryApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register-admin")
    public ResponseEntity<?>adminsRegistrations(@RequestBody AdminsRegistrationRequest request){
        try {
            AdminsRegistrationResponse response = libraryServices.adminsRegistration(request);
            return new ResponseEntity<>(new libraryApiResponse(true, response), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new libraryApiResponse(false, e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/register-reader")
    public ResponseEntity<?>newReadersRegistrations(@RequestBody ReadersRegistrationRequest request){
        try{
            ReadersRegistrationResponse response = libraryServices.newReadersRegistration(request);
            return new ResponseEntity<>(new libraryApiResponse(true, response), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new libraryApiResponse(false, e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/login-reader")
    public ResponseEntity<?> getReadersLoginRequest(@RequestBody ReadersLoginRequest request){

        try {
            ReadersLoginResponse response = libraryServices.readerLogin(request);
            return new ResponseEntity<>(new libraryApiResponse(true, response), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new libraryApiResponse(false, e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/login-admin")
    public ResponseEntity<?> getAdminsLoginRequest(@RequestBody AdminsLoginRequest request){
        try{
            AdminsLoginResponse response = libraryServices.adminsLogin(request);
            return new ResponseEntity<>(new libraryApiResponse(true, response), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new libraryApiResponse(false, e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping("/get-books-by-title/{title}")
    public ResponseEntity<?> getBookByTitle(@PathVariable("title") String title) {
        try {
            Book response = libraryServices.readBookByTitle(title);
            return new ResponseEntity<>( new libraryApiResponse(true,response), HttpStatus.OK);
            }
            catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
    }

    @GetMapping("/allBooks")
    public ResponseEntity<?> getAllBooks() {
        try{
            List<Book> response = libraryServices.readBooks();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new libraryApiResponse(false, e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete-all")
    public DeleteBookResponse deleteBook() {
        return libraryServices.deleteAllBook();
    }

    @GetMapping("/get-book-by-author/{author}")
    public ResponseEntity<?> getBookByAuthor(@PathVariable("author") String author) {
        try{
            SearchBookByAuthorResponse response = libraryServices.readBookByAuthor(author);
            return new ResponseEntity<>(new libraryApiResponse(true, response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new libraryApiResponse(false, e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/lend-book")
    public ResponseEntity<?> lendBook(@PathVariable LendBookRequest request) {
        try{
            Reader response = libraryServices.lendBook(request, request.getTitle());
            return new ResponseEntity<>(new libraryApiResponse(true, response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new libraryApiResponse(false, e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }
}

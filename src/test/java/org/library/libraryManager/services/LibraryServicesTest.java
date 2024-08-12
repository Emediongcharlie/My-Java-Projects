package org.library.libraryManager.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.libraryManager.data.models.Book;
import org.library.libraryManager.data.models.ClassOfUser;
import org.library.libraryManager.data.models.Librarian;
import org.library.libraryManager.data.repositories.BookRepository;
import org.library.libraryManager.dtos.requests.*;
import org.library.libraryManager.dtos.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.library.libraryManager.data.models.ClassOfUser.ADMIN;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@SpringBootTest
public class LibraryServicesTest {

    @Autowired
    private LibraryServices libraryServices;
    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        libraryServices.deleteAllBook();
    }


    @Test
    public void testAddBook() {
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setAuthor("Emediong Charlie");
        addBookRequest.setTitle("Java test");
        addBookRequest.setIsbn("11111");
        addBookRequest.setYearOfPublication("1991");
        AddBookResponse response = libraryServices.addBook(addBookRequest);

        AddBookRequest addBookRequest2 = new AddBookRequest();
        addBookRequest2.setAuthor("Emediong Charlie");
        addBookRequest2.setTitle("Java test2");
        addBookRequest2.setIsbn("22222");
        addBookRequest2.setYearOfPublication("1992");
        AddBookResponse addBookResponse2 = libraryServices.addBook(addBookRequest2);
        assertThat(addBookResponse2).isNotNull();
        assertThat(response).isNotNull();
        assertThat(response.getAuthor().contains("Emediong Charlie"));
    }


    @Test
    public void testAdminCanRegister() {
        AdminsRegistrationRequest addAdminsRequest = new AdminsRegistrationRequest();
        Librarian librarian = new Librarian();
        librarian.setClassOfUser(ADMIN);
        addAdminsRequest.setClassOfUser(ADMIN);
        addAdminsRequest.setFirstName("Emediong");
        addAdminsRequest.setLastName("Charlie");
        addAdminsRequest.setEmail("emediong@charlie.com");
        addAdminsRequest.setPassword("1111");
        addAdminsRequest.setUsername("emediong");
        AdminsRegistrationResponse response = libraryServices.adminsRegistration(addAdminsRequest);
        assertThat(response).isNotNull();
        assertThat(response.getEmail().contains("emediong@charlie.com"));
    }

    @Test
    public void testAdminCanLogin() {
        AdminsLoginRequest addAdminsRequest = new AdminsLoginRequest();
        AdminsLoginRequest loginRequest = new AdminsLoginRequest();
        addAdminsRequest.setUsername("emediong");
        addAdminsRequest.setPassword("1111");
        loginRequest.setUsername("emediong");
        loginRequest.setPassword("1111");
        assertThat(libraryServices.adminsLogin(loginRequest)).isNotNull();
        AdminsLoginResponse response = libraryServices.adminsLogin(loginRequest);
        assertThat(response.getMessage().contains("Successfully logged in"));
    }

    @Test
    public void testThatReaderCanRegister() {
        ReadersRegistrationRequest readersRegistrationRequest = new ReadersRegistrationRequest();
        readersRegistrationRequest.setFirstName("Emediong");
        readersRegistrationRequest.setLastName("Charlie");
        readersRegistrationRequest.setEmail("emediong@charlie.com");
        readersRegistrationRequest.setPassword("1111");
        readersRegistrationRequest.setPhoneNumber("0800657535435");
        ReadersRegistrationResponse response = libraryServices.newReadersRegistration(readersRegistrationRequest);
        assertThat(response).isNotNull();
        assertThat(response.getEmail().contains("emediong@charlie.com"));
    }

    @Test
    public void testThatReaderCanLogin() {
        ReadersLoginRequest readersLoginRequest = new ReadersLoginRequest();
        readersLoginRequest.setUsername("emediong");
        readersLoginRequest.setPassword("1111");
        ReadersLoginResponse response = libraryServices.readerLogin(readersLoginRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage().contains("Successfully logged in"));
    }

    @Test
    public void testReadBookByIsbn() {
        SearchBookByIsbnRequest request = new SearchBookByIsbnRequest();
        request.setIsbn("1111");
        request.setAuthor("Emediong Charlie");
        request.setTitle("Java test");
        SearchBookByTitleResponse response = new SearchBookByTitleResponse();
        response.setIsbn("1111");
        response.setAuthor("Emediong Charlie");
        response.setTitle("Java test");
        assertThat(response).isNotNull();
        assertThat(response.getIsbn().contains("1111")).isTrue();
    }

    @Test
    public void testReadBookByTitle() {
        SearchBookByTitleRequest searchBookByTitleRequest = new SearchBookByTitleRequest();
        SearchBookByTitleResponse searchBookByTitleResponse = new SearchBookByTitleResponse();
        searchBookByTitleRequest.setTitle("Emediong Charlie");
        searchBookByTitleRequest.setAuthor("Java test");
        searchBookByTitleRequest.setIsbn("11111");
        searchBookByTitleResponse.setTitle("Emediong Charlie");
        searchBookByTitleResponse.setAuthor("Java test");
        searchBookByTitleResponse.setIsbn("11111");
        assertThat(searchBookByTitleResponse).isNotNull();
        assertThat(searchBookByTitleResponse.getTitle()).isEqualTo("Emediong Charlie");
        assertThat(searchBookByTitleResponse.getAuthor()).isEqualTo("Java test");

    }
    @Test
    public void testDeleteAll(){
        AddBookRequest request = new AddBookRequest();
        request.setIsbn("1111");
        request.setAuthor("Emediong Charlie");
        request.setTitle("Java test");
        AddBookResponse response = libraryServices.addBook(request);
        response.setTitle("title");
        assertThat(response).isNotNull();
        DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
        deleteBookRequest.setTitle("Java Test");
        DeleteBookResponse deleteBookResponse = new DeleteBookResponse();
        deleteBookResponse.setMessage("successfully deleted");
        assertThat(deleteBookResponse.getTitle()).isNull();
    }
}



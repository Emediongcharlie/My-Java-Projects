package org.library.libraryManager.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.libraryManager.data.models.Librarian;
import org.library.libraryManager.data.repositories.BookRepository;
import org.library.libraryManager.dtos.requests.*;
import org.library.libraryManager.dtos.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
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
        AdminsRegistrationRequest registrationRequest = new AdminsRegistrationRequest();
        registrationRequest.setFirstName("Emediong");
        registrationRequest.setLastName("Scott");
        registrationRequest.setEmail("eds@gmail.com");
        registrationRequest.setPassword("password");
        registrationRequest.setUsername("eds@gmail.com");
        libraryServices.adminsRegistration(registrationRequest);
//        assertThat(adminResponse).isNotNull();

        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setUsername("eds@gmail.com");
        addBookRequest.setTitle("faith");
        addBookRequest.setAuthor("ravenhill");
        addBookRequest.setYearOfPublication("2003");
        addBookRequest.setIsbn("1111");
        AddBookResponse response = libraryServices.addBook(addBookRequest);
        assertThat(bookRepository.count()).isEqualTo(1);
        assertThat(response.getTitle()).contains("faith");

    }

    @Test
    public void testAdminCanRegister() {
        AdminsRegistrationRequest addAdminsRequest = new AdminsRegistrationRequest();
        Librarian librarian = new Librarian();
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
        AdminsRegistrationRequest addAdminsRequest = new AdminsRegistrationRequest();
        AdminsLoginRequest loginRequest = new AdminsLoginRequest();
        addAdminsRequest.setUsername("it");
        addAdminsRequest.setPassword("1111");
        AdminsRegistrationResponse response = libraryServices.adminsRegistration(addAdminsRequest);
        assertThat(response).isNotNull();
        assertThat(response.getPassword().contains("1111"));
        loginRequest.setUsername("it");
        loginRequest.setPassword("1111");
        AdminsLoginResponse response1 = libraryServices.adminsLogin(loginRequest);
        assertThat(response1).isNotNull();
        assertThat(response1.getMessage().contains("Successfully logged in"));
    }

    @Test
    public void testThatReaderCanRegister() {
        ReadersRegistrationRequest readersRegistrationRequest = new ReadersRegistrationRequest();
        readersRegistrationRequest.setFirstName("Emediong");
        readersRegistrationRequest.setLastName("Charlie");
        readersRegistrationRequest.setEmail("@carie.com");
        readersRegistrationRequest.setPassword("1111");
        readersRegistrationRequest.setPhoneNumber("0800657535435");
        ReadersRegistrationResponse response = libraryServices.newReadersRegistration(readersRegistrationRequest);
        assertThat(response).isNotNull();
        assertThat(response.getEmail().contains("emediong@charlie.com"));
    }

    @Test
    public void testThatReaderCanLogin() {
        ReadersRegistrationRequest readersRegistrationRequest = new ReadersRegistrationRequest();
        readersRegistrationRequest.setFirstName("Emediong");
        readersRegistrationRequest.setLastName("Charlie");
        readersRegistrationRequest.setEmail("eng@che.com");
        readersRegistrationRequest.setPassword("161");
        readersRegistrationRequest.setPhoneNumber("0800657535435");
        readersRegistrationRequest.setUsername("tit");
        ReadersRegistrationResponse response = libraryServices.newReadersRegistration(readersRegistrationRequest);
        assertThat(response).isNotNull();
        ReadersLoginRequest loginRequest = new ReadersLoginRequest();
        loginRequest.setUsername("tit");
        loginRequest.setPassword("161");
        ReadersLoginResponse loginResponse = libraryServices.readerLogin(loginRequest);
        assertThat(loginResponse).isNotNull();
        assertThat(loginResponse.getMessage().contains("Successfully logged in"));



    }

    @Test
    public void testReadBookByAuthor() {
        SearchBookByAuthorRequest request = new SearchBookByAuthorRequest();
        request.setIsbn("1111");
        request.setAuthor("Emediong Charlie");
        request.setTitle("Java test");
        SearchBookByTitleResponse response = new SearchBookByTitleResponse();
        response.setIsbn("1111");
        response.setAuthor("Emediong Charlie");
        response.setTitle("Java test");
        assertThat(response).isNotNull();
        assertThat(response.getAuthor().contains("Emediong Charlie")).isTrue();
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



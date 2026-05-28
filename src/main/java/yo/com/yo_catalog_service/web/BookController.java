package yo.com.yo_catalog_service.web;

import jakarta.validation.Valid;


import org.springframework.http.HttpStatus;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import yo.com.yo_catalog_service.domain.Book;
import yo.com.yo_catalog_service.domain.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("books")
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping("/me")
//    public List<String> getGretting(JwtAuthenticationToken auth) {
//        return auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
//    }
//
//    @GetMapping("/me/debug")
//    public Map<String, Object> debugToken(JwtAuthenticationToken auth) {
//        return auth.getToken().getClaims();
//    }

    @GetMapping
    public Iterable<Book> get() {
        log.info("Fetching list of books in db");
        return bookService.viewBookList();
    }

    @GetMapping("{isbn}")
    public Book getByIsbn(@PathVariable String isbn) {
        log.info("Fetching book with ISBN: {}", isbn);
        return bookService.viewBookDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@Valid @RequestBody Book book) {
        log.info("Adding new book with ISBN: {}", book.isbn());
        return bookService.addBookToCatalog(book);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn) {
        log.info("Deleting book with ISBN: {}", isbn);
        bookService.removeBookFromCatalog(isbn);
    }

    @PutMapping("{isbn}")
    public Book put(@PathVariable String isbn, @Valid @RequestBody Book book) {
        log.info("Editing book with ISBN: {}", isbn);
        return bookService.editBookDetails(isbn, book);
    }

}

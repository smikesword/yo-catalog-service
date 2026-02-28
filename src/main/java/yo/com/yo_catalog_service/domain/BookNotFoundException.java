package yo.com.yo_catalog_service.domain;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String isbn) {
        super("The book with ISBN " + isbn + " was not found.");
    }

}

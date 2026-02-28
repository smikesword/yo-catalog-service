package yo.com.yo_catalog_service.demo;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import yo.com.yo_catalog_service.domain.Book;
import yo.com.yo_catalog_service.domain.BookRepository;

@Component
@Profile("testdata")
public class BookDataLoader {

	private final BookRepository bookRepository;

	public BookDataLoader(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void loadBookTestData() {
        bookRepository.deleteAll();
		var book1 = Book.of("1234567891", "Neon lights", "Lyra Silverstar", 9.90, "Manning");
		var book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90, "Manning");
		bookRepository.save(book1);
		bookRepository.save(book2);
	}

}

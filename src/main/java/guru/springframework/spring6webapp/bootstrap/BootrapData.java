package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstname("Eric");
        eric.setLastname("Smith");

        Book dddBook = new Book();
        dddBook.setTitle("Spring 6 Web App");
        dddBook.setIsbn("978-3-16-148410-0");

        Author savedEric = authorRepository.save(eric);
        Book savedBook = bookRepository.save(dddBook);

        Author johnDoe = new Author();
        johnDoe.setFirstname("John");
        johnDoe.setLastname("Doe");

        Book aaaBook = new Book();
        aaaBook.setTitle("Spring boot 6 Web App");
        aaaBook.setIsbn("97222228-3-16-148410-0");

        Author savedJohnDoe = authorRepository.save(johnDoe);
        Book savedaaaBook2 = bookRepository.save(aaaBook);

        savedEric.getBooks().add(savedBook);
        savedJohnDoe.getBooks().add(savedaaaBook2);

        authorRepository.save(savedEric);
        authorRepository.save(savedJohnDoe);

        System.out.println("In bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());



    }
}

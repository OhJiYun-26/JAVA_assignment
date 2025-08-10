package mylab.library.control;

import jakarta.annotation.PostConstruct;
import mylab.library.entity.Book;
import mylab.library.entity.Library;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final Library library;

    public DataLoader(Library library) {
        this.library = library;
    }

    @PostConstruct
    void load() {
        add("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022);
        add("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015);
        add("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008);
        add("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018);
        add("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005);
        add("자바의 정석", "남궁성", "978-89-01-14077-4", 2019);
    }

    private void add(String title, String author, String isbn, int year) {
        library.addBook(new Book(title, author, isbn, year));
        System.out.println("도서가 추가되었습니다: " + title);
    }
}

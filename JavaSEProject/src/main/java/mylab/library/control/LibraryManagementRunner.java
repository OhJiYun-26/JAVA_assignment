package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class LibraryManagementRunner implements CommandLineRunner {

    private final Library library;

    public LibraryManagementRunner(Library library) {
        this.library = library;
    }

    @Override
    public void run(String... args) {
        printHeader();
        printStats();

        testFindBook();
        testCheckOut();
        testReturn();
        displayAvailableBooks();
    }

    private void printHeader() {
        System.out.println("===== " + library.getName() + " =====");
    }

    private void printStats() {
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
        System.out.println();
    }

    private void testFindBook() {
        System.out.println("===== 도서 검색 테스트 =====");
        System.out.println("제목으로 검색 결과:");
        Book byTitle = library.findBookByTitle("자바의 정석");
        if (byTitle != null) System.out.println(byTitle);
        else System.out.println("검색 결과가 없습니다.");

        System.out.println();
        System.out.println("저자로 검색 결과:");
        List<Book> byAuthor = library.findBooksByAuthor("Robert C. Martin");
        if (byAuthor.isEmpty()) System.out.println("검색 결과가 없습니다.");
        else System.out.println(byAuthor.get(0));
        System.out.println();
    }

    private void testCheckOut() {
        System.out.println("===== 도서 대출 테스트 =====");
        boolean ok = library.checkOutBook("978-89-01-14077-4");
        System.out.println(ok ? "도서 대출 성공!" : "도서 대출 실패");
        System.out.println("대출된 도서 정보:");
        System.out.println(library.findBookByISBN("978-89-01-14077-4"));
        System.out.println();
        System.out.println("도서관 현재 상태:");
        printStats();
    }

    private void testReturn() {
        System.out.println("===== 도서 반납 테스트 =====");
        boolean ok = library.returnBook("978-89-01-14077-4");
        System.out.println(ok ? "도서 반납 성공!" : "도서 반납 실패");
        System.out.println("반납된 도서 정보:");
        System.out.println(library.findBookByISBN("978-89-01-14077-4"));
        System.out.println();
        System.out.println("도서관 현재 상태:");
        printStats();
    }

    private void displayAvailableBooks() {
        System.out.println("===== 대출 가능한 도서 목록 =====");
        for (Book b : library.getAvailableBooks()) {
            System.out.println(b);
            System.out.println("------------------------");
        }
    }
}

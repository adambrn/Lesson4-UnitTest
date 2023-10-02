package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById() {
        // Создаем тестовые данные
        String bookId = "1";
        Book expectedBook = new Book(bookId, "Book1", "Author1");

        // Настраиваем поведение мок-объекта
        when(bookRepository.findById(bookId)).thenReturn(expectedBook);

        // Вызываем метод, который тестируем
        Book actualBook = bookService.findBookById(bookId);

        // Проверяем, что метод вернул ожидаемую книгу
        assertEquals(expectedBook, actualBook);
    }

    @Test
    public void testFindAllBooks() {
        // Создаем тестовые данные
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book1", "Author1"));
        expectedBooks.add(new Book("2", "Book2", "Author2"));

        // Настраиваем поведение мок-объекта
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Вызываем метод, который тестируем
        List<Book> actualBooks = bookService.findAllBooks();

        // Проверяем, что метод вернул ожидаемый список книг
        assertEquals(expectedBooks, actualBooks);
    }
}

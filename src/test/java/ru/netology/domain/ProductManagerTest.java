package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(72, "Lord of the rings 1", 100, "Tolkien");
    Book book2 = new Book(13, "The Silmarillion", 150, "Tolkien");
    Book book3 = new Book(55, "Lord of the rings 3", 200, "Tolkien");
    Book book4 = new Book(55, "Java 24 hours", 200, "Cadenhead");


    @Test
    public void shouldSearchIfMatchesSeveral() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("rings");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchIfNoMatches() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("yes");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSearchIfDidNotAdd() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("null");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchIfOne() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book4};
        Product[] actual = manager.searchBy("Java");

        Assertions.assertArrayEquals(expected, actual);

    }
}

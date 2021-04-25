package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.manager.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book1 = new Book(1, "Book", 100, "Jack London");
    Book book2 = new Book(2, "Book", 200, "Information");
    Book book3 = new Book(3, "Book", 400, "Ахматова");
    Book book4 = new Book(4, "Book", 250, "Ахматова");
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void getUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
    }

    @Test
    public void searchTwoRussianWords() {
        Product[] actual = manager.searcyBy("Ахматова");
        Product[] expected = new Product[]{book3, book4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWithCase() {
        Product[] actual = manager.searcyBy("INFORMATION");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySecondWord() {
        Product[] actual = manager.searcyBy("London");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void searchNoExistsWord() {
        Product[] actual = manager.searcyBy("Samsung");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}
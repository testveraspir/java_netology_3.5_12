package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    Book book1 = new Book(1, "Information", 100, "Jack London");
    Book book2 = new Book(2, "Motorola", 200, "Information");
    Book book3 = new Book(3, "Ахматова и Цветаева", 400, "Ахматова");
    Smartphone smartphone1 = new Smartphone(4, "Information", 25, "Китай");
    Smartphone smartphone2 = new Smartphone(5, "Motorola", 10000, "Information");

    @Test
    public void searchByAllFields() {
        ProductManager manager = new ProductManager(repository);
        Product[] returned = new Product[]{book1, book2, book3, smartphone1, smartphone2};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Information");
        Product[] expected = new Product[]{book1, book2, smartphone1, smartphone2};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByAllFieldsByPartWord() {
        ProductManager manager = new ProductManager(repository);
        Product[] returned = new Product[]{book1, book2, book3, smartphone1, smartphone2};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Info");
        Product[] expected = new Product[]{book1, book2, smartphone1, smartphone2};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchWithCase() {
        ProductManager manager = new ProductManager(repository);
        Product[] returned = new Product[]{book1, book2, book3, smartphone1, smartphone2};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("motorola");
        Product[] expected = new Product[]{book2, smartphone2};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchRussianWord() {
        ProductManager manager = new ProductManager(repository);
        Product[] returned = new Product[]{book1, book2, book3, smartphone1, smartphone2};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Китай");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTwoFieldsByOneExemplar() {
        ProductManager manager = new ProductManager(repository);
        Product[] returned = new Product[]{book1, book2, book3, smartphone1, smartphone2};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Ахматова");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchBySecondWord() {
        ProductManager manager = new ProductManager(repository);
        Product[] returned = new Product[]{book1, book2, book3, smartphone1, smartphone2};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("London");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);

    }


    @Test
    public void searchNoExistingWord() {
        ProductManager manager = new ProductManager(repository);
        Product[] returned = new Product[]{book1, book2, book3, smartphone1, smartphone2};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Samsung");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);

    }

}


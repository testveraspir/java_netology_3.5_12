package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.manager.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone1 = new Smartphone(1, "Smartphone1", 25, "Китай");
    Smartphone smartphone2 = new Smartphone(2, "Smartphone2", 10000, "America");
    Smartphone smartphone3 = new Smartphone(3, "Smartphone3", 15000, "America");
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void getUp() {
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
    }

    @Test
    public void searchTwoWordsWithCase() {
        Product[] actual = manager.searcyBy("AMERICA");
        Product[] expected = new Product[]{smartphone2, smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchRussianWord() {
        Product[] actual = manager.searcyBy("Китай");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNoExistsWord() {
        Product[] actual = manager.searcyBy("Samsung");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}
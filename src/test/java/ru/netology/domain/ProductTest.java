package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.manager.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product1 = new Product(1, "Information", 100);
    Product product2 = new Product(2, "Motorola Moto", 200);
    Product product3 = new Product(3, "Ахматова и Цветаева", 200);
    Product product4 = new Product(4, "Information", 200);
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void getUp() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
    }

    @Test
    public void searchOneProduct() {
        Product[] actual = manager.searcyBy("Motorola Moto");
        Product[] expected = new Product[]{product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTwoProductsWithCase() {
        Product[] actual = manager.searcyBy("INFORMATION");
        Product[] expected = new Product[]{product1, product4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySecondWord() {
        Product[] actual = manager.searcyBy("Moto");
        Product[] expected = new Product[]{product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchRussianWord() {
        Product[] actual = manager.searcyBy("Ахматова");
        Product[] expected = new Product[]{product3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNoExistsWord() {
        Product[] actual = manager.searcyBy("Samsung");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}
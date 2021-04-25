package ru.netology.manager;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

@Getter
@Setter
public class ProductManager {
    private ProductRepository repository;
    private String search;

    public ProductManager() {
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;

    }

    public boolean matches(Product product, String search) {

        if (product instanceof Book ) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }

        } else {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }

        }
        return false;
    }

    public Product[] searcyBy(String text) {
        Product[] result = new Product[0];
        Product[] rep = repository.findAll();
        for (Product product : rep) {
            if (matches(product, text)) {

                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}

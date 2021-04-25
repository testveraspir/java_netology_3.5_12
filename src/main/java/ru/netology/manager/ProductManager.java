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

    public Product[] searcyBy(String text) {
        Product[] result = new Product[0];
        Product[] rep = repository.findAll();
        for (Product product : rep) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}

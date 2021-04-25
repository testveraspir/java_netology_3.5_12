package ru.netology.manager;

import lombok.Generated;
import ru.netology.domain.Product;
@Generated
public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] result = new Product[length];
        for (int i = 0; i < products.length; i++) {
            result[i] = products[i];
        }
        result[result.length - 1] = product;
        products = result;
    }

    public Product[] remoteById(int id) {
        int length = products.length - 1;
        Product[] result = new Product[length];
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() != id) {
                result[i] = products[i];
            }
            products = result;
        }

        return products;
    }

    public Product[] findAll() {
        return products;
    }
}

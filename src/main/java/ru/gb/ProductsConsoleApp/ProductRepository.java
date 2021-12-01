package ru.gb.ProductsConsoleApp;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product(0, "bread", 45));
        products.add(new Product(1, "cake", 90));
        products.add(new Product(2, "salt", 35));
        products.add(new Product(3, "sugar", 75));
        products.add(new Product(4, "milk", 80));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);   //to prevent from modifying list "products"
    }

    public Product findById(int id) {
        if(id >=0 && id < products.size()) {
            return products.get(id);
        }
        return null;
    }

}

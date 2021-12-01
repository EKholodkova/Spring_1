package ru.gb.ProductsConsoleApp;

import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@ToString
@Component
@Scope("prototype")
public class Cart {
    private final Map<Integer, Product> products = new HashMap<>();

    public void add(Product product) {
        products.put(product.getId(), product);
    }

    public void removeById(int id) {
        products.remove(id);
    }

    public void showProductList() {
        System.out.println(products);
    }
}

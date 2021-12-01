package ru.gb.ProductsConsoleApp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RequiredArgsConstructor
@Component
public class CartManager implements ShopController {
    private final ProductRepository productRepository;
    private Cart cart;

    @Lookup
    @Override
    public Cart getCart() {
        return null;
    }

    public void showAssortment() {
        System.out.println(productRepository.findAll());
    }

    public void addProductToCartById(int id) {
        cart.add(productRepository.findById(id));
    }

    public void deleteProductFromCartById(int id) {
        cart.removeById(id);
    }

    public void showProductsInCart() {
        cart.showProductList();
    }

    public Cart enterToShop() {
        this.cart = getCart();
        return cart;
    }

    public Cart processCart() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request;
        Cart myCart = enterToShop();
        while(!(request = reader.readLine()).equals(Commands.EXIT)) {
            String[] reqWithParams = request.split(" ");
            switch (reqWithParams[0]) {
                case (Commands.ADD) :
                    addProductToCartById(Integer.parseInt(reqWithParams[1]));
                    break;
                case (Commands.RM) :
                    deleteProductFromCartById(Integer.parseInt(reqWithParams[1]));
                    break;
                case (Commands.SHOW_ASSORTMENT) :
                    showAssortment();
                    break;
                case (Commands.SHOW_CART) :
                    showProductsInCart();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + reqWithParams[0]);
            }
        }
        return myCart;
    }
}

package ru.gb.ProductsConsoleApp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HWConfig.class);
        CartManager manager = context.getBean(CartManager.class);
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(manager.processCart());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

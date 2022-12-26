package ua.ithillel.lesson38.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson38.homework.cart.Cart;

public class CartApplication {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext("ua.ithillel.lesson38.homework.cart");
        System.out.println(ctx.getBean(Cart.class));
        System.out.println(ctx.getBean(Cart.class));
    }
}

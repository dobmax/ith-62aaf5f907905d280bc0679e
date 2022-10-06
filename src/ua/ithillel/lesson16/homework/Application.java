package ua.ithillel.lesson16.homework;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Application {

    static List<Product> doTask1(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals(Product.Type.BOOK))
                .toList();
    }

    static List<Product> doTask2(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals(Product.Type.BOOK) && product.isSale())
                .map(product -> new Product(product.getType(), product.getPrice(), product.isSale()))
                .toList();
    }

    static Product doTask3(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals(Product.Type.BOOK))
                .min((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()))
                .orElseThrow(() -> new RuntimeException("No product found on category " + Product.Type.BOOK));
    }

    static List<Product> doTask4(List<Product> products) {
        return products.stream()
                .sorted((o1, o2) -> Long.compare(o2.getCreated().toEpochDay(), o1.getCreated().toEpochDay()))
                .limit(3)
                .toList();
    }

    static float doTask5(List<Product> products) {
        AtomicReference<Float> sum = new AtomicReference<>();

        products.stream()
                .filter(product -> product.getType().equals(Product.Type.BOOK)
                        && product.getCreated().getYear() == 2022
                        && product.getPrice() <= 75)
                .forEach(product -> sum.updateAndGet(v -> v + product.getPrice()));

        return sum.get();
    }

}

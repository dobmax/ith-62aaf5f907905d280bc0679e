package ua.ithillel.lesson38.homework.cart;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.ithillel.lesson38.homework.Product;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
@Scope("prototype")
public class Cart {

    ProductRepository productRepository;

    public void addOrder(Product... products) {

    }

    public void removeProduct(long id) {

    }

    @Override
    public String toString() {
        return "Cart["  + hashCode() + "] : repo[" + productRepository.hashCode() + "]";
    }
}

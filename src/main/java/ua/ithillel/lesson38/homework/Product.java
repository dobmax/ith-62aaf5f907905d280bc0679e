package ua.ithillel.lesson38.homework;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    long id;
    String name;
    BigDecimal price;
}

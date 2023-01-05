package ua.ithillel.lesson39.homework.data.access.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {
    long id;
    String name;
    List<Product> products;
}

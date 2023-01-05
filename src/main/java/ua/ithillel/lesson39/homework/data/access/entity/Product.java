package ua.ithillel.lesson39.homework.data.access.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    long id;
    String name;
    float price;
}

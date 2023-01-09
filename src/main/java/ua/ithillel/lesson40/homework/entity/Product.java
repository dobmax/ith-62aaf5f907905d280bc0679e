package ua.ithillel.lesson40.homework.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    long id;
    String name;
    BigDecimal cost;
}

package ua.ithillel.lesson40.homework.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    long id;

    Instant date;
    BigDecimal cost;
    List<Product> products;
}

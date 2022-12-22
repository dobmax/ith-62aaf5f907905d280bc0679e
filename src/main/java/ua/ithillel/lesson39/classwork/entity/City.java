package ua.ithillel.lesson39.classwork.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City {
    long id;
    String name;
    int population;
    Country country;
}

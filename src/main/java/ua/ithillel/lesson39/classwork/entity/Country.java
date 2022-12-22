package ua.ithillel.lesson39.classwork.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {
    long id;
    String name;
    Mainland mainland;
}

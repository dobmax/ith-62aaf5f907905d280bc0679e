package ua.ithillel.lesson26.homework;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @NonNull
    int number;
    @NonNull
    String name;
}

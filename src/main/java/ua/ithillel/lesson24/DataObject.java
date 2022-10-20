package ua.ithillel.lesson24;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class DataObject<T> {
    T val1;
    T val2;
    T val3;
}

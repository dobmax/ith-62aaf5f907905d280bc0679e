package ua.ithillel.lesson25.homework;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ArrayMethods {

    public int[] subarrayAfterFour(int[] values) {
        if (values == null || values.length == 0)
            throw new RuntimeException("Array must contain one four-digit at least");

        int idx = -1;

        for (int i = 0; i < values.length; i++) {
            if (values[i] == 4) idx = i;
        }

        if (idx == -1) throw new RuntimeException("Array must contain one four-digit at least");

        var newLength = values.length - idx - 1;
        var newValues = new int[newLength];
        System.arraycopy(values, idx + 1, newValues, 0, newLength);

        return newValues;
    }
}

package ua.ithillel.lesson28.homework;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Sortings {

    /**
     * Sorting algorithm works with a new object
     */
    public int[] shake(int[] values) {
        throw new Error();
    }

    /**
     * Sorting algorithm works with a link
     */
    public void shakeSilent(int[] values) {
        if (values == null || values.length == 0) return;


        for (int i = 0; i < values.length; i++) {
            for (int j = i; j < values.length - 1; j++) {
                if (values[j] > values[j + 1]) {
                    var temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }

            for (int j = values.length - 1 - i; j > 0; j--) {
                if (values[j] < values[j - 1]) {
                    var temp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = temp;
                }
            }
        }
    }
}

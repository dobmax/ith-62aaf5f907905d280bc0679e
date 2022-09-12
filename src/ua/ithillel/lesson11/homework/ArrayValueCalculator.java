package ua.ithillel.lesson11.homework;

public class ArrayValueCalculator {

    public int doCalc(String[][] values) {
        checkSize(values.length);
        for (String[] value : values) {
            checkSize(value.length);
        }

        int sum = 0;
        for (String[] digits : values) {
            for (String digit : digits) {
                try {
                    sum += Integer.parseInt(digit);
                } catch (RuntimeException e) {
                    throw new MyArrayDataException("A value of array is not parseable int.: [x: y:]", e);
                }
            }
        }

        return sum;
    }

    private void checkSize(int length) {
        if (length != 4) {
            throw new MyArraySizeException("Array must be in strict dimension 4x4");
        }
    }

}

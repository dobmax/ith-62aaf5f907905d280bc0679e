package ua.ithillel.lesson21.homework;

import java.time.Duration;
import java.util.Arrays;

public class ValueCalculator {

    private static final int VALUES_SIZE = 50_000_000;
    private static final int VALUES_SIZE_HALF = VALUES_SIZE / 2;
    private float[] values = new float[VALUES_SIZE];

    public void doCalc() {
        long start = System.currentTimeMillis();

        Arrays.fill(values, 1);

        float[] part1 = new float[VALUES_SIZE_HALF];
        float[] part2 = new float[VALUES_SIZE_HALF];

        System.arraycopy(values, 0, part1, 0, VALUES_SIZE_HALF);
        System.arraycopy(values, VALUES_SIZE_HALF, part2, 0, VALUES_SIZE_HALF);

        var t1 = new Thread(() -> executeFunc(part1));
        var t2 = new Thread(() -> executeFunc(part2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(part1, 0, values, 0, VALUES_SIZE_HALF);
        System.arraycopy(part2, 0, values, VALUES_SIZE_HALF, VALUES_SIZE_HALF);

        long timeTaken = System.currentTimeMillis() - start;
//        System.out.println("Operation took: " + timeTaken);
//        System.out.println("Operation took: " + Duration.ofMillis(timeTaken).getSeconds());
        System.out.println("Operation took: " + Duration.ofMillis(timeTaken).toMillis());
    }

    private void executeFunc(float[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = (float) (values[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}

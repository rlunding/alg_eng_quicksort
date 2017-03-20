package org.lunding;

import java.util.*;

/**
 * Created by lunding on 17/02/2017.
 */
public class DataGenerator {



    public static int[] generateRandomNumbers(int size) {
        int numbers[] = new int[size];
        for (int i=0; i<size; i++) {
            numbers[i] = i;
        }
        shuffleArray(numbers);
        return numbers;
    }

    public static int[] generateAlmostSortedNumbers(int size) {
        int bound = (int) (size*0.20f);
        return generateAlmostSortedNumbers(size, bound);
    }

    public static int[] generateAlmostSortedNumbers(int size, int bound) {
        Random random = new Random();
        int numbers[] = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i - bound/2 + random.nextInt(bound);
        }
        return numbers;
    }

    private static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}

package org.lunding;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lunding on 19/02/2017.
 */
public class GeneralTest {

    private int numbers[];
    private int size = 100;//4194304;

    @Before
    public void setUp() {
        numbers = DataGenerator.generateRandomNumbers(size);
    }

    @Test
    public void testDataGenerator() {
        //System.out.println(Arrays.toString(numbers));
    }

    @Test
    public void largeInsertionSortTest() {
        InsertionSort.sort(numbers);
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
    }

    @Test
    public void largeOptimizedInsertionSortTest() {
        InsertionSort.optimizedSort(numbers);
        for (int i = 1; i < size; i++) {
            assertThat("Not the same: " + numbers[i - 1] + " < " + numbers[i], numbers[i - 1] < numbers[i], is(true));
        }

    }

    @Test
    public void javansertionSortTest() {
        InsertionSort.javaSort(numbers);
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
    }

    @Test
    public void largeSimpleQuicksortTest0() {
        (new SimpleQuicksort(0)).sort(numbers);
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
    }

    @Test
    public void largeSimpleQuicksortTest20() {
        (new SimpleQuicksort(20)).sort(numbers);
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
    }

    @Test
    public void largeJRETest() {
        (new JRE(20, 2, 4)).sort(numbers);
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
    }

    @Test
    public void largeDualPivotQuicksortTest() {
        (new JRE(20, 2, 4)).sort(numbers);
        for (int i = 1; i < size; i++) {
            assertThat("Not the same: " + numbers[i - 1] + " < " + numbers[i], numbers[i - 1] < numbers[i], is(true));
        }
    }

    @Test
    public void largeDualQuickTest() {
        (new QuickDualPivot(7)).sort(numbers);
        System.out.println(Arrays.toString(numbers));
        for (int i = 1; i < size; i++) {
            assertThat("Not the same: " + numbers[i - 1] + " < " + numbers[i], numbers[i - 1] < numbers[i], is(true));
        }
    }

    @Test
    public void largeMergesortTest() {
        (new Mergesort(7)).sort(numbers);
        for (int i = 1; i < size; i++) {
            assertThat("Not the same: " + numbers[i - 1] + " < " + numbers[i], numbers[i - 1] < numbers[i], is(true));
        }
    }

    @Test
    public void largeParallelTest() {
        (new ParallelQuicksort(0)).sort(numbers);
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
    }


}

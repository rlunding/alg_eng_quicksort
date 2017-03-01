package org.lunding;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by lunding on 15/02/2017.
 */
public class InsertionSortTest {


    @Before
    public void setUp() {

    }

    @Test
    public void sortTest() {
        int[] numbers = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Util.shuffleArray(numbers);
        InsertionSort.sort(numbers);

        for (int i = 1; i < numbers.length; i++) {
            assertThat(numbers[i-1] < numbers[i], is(true));
        }
    }

}
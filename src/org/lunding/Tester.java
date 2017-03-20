package org.lunding;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * Created by lunding on 19/02/2017.
 */
public class Tester {

    public static void main(String args[]) {
        //int numbers[] = DataGenerator.generateAlmostSortedNumbers(30, 4);
        long start = System.currentTimeMillis();
        int numbers[] = DataGenerator.generateRandomNumbers(10000000);
        Arrays.sort(numbers);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        long start1 = System.currentTimeMillis();
        int numbers1[] = DataGenerator.generateRandomNumbers(10000000);
        (new Mergesort(50)).sort(numbers1);
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);


    }
}

package org.lunding;

import java.util.*;

/**
 * Created by lunding on 16/02/2017.
 */
public class SkewedPivotQuicksort {

    private int INSERTION_SORT_CUTOFF;
    private int TERTILE;

    public SkewedPivotQuicksort(int INSERTION_SORT_CUTOFF, int TERTILE) {
        this.INSERTION_SORT_CUTOFF = INSERTION_SORT_CUTOFF;
        this.TERTILE = TERTILE;
    }

    public void sort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        sort(input, 0, input.length-1);
    }

    public void sort(int[] input, int left, int right) {
        int length = right - left + 1;
        if (length < INSERTION_SORT_CUTOFF) {
            InsertionSort.optimizedSort(input, left, right);
            return;
        }

        // Cheap approximation for length/7
        int tertiles[] = new int[5];
        int s7 = (length >> 3) + (length >> 6) + 1;
        tertiles[2] = (left + right) >>> 1;
        tertiles[1] = tertiles[2] - s7;
        tertiles[0] = tertiles[1] - s7;
        if (length == 8) ++tertiles[0];
        tertiles[3] = tertiles[2] + s7;
        tertiles[4] = tertiles[3] + s7;

        int i = left;
        int j = right;

        int pivot = input[tertiles[TERTILE]];

        while (i <= j) {
            while(input[i] < pivot) {
                i++;
            }
            while(input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(input, i, j);
                i++;
                j--;
            }
        }
        if (left < j) {
            sort(input, left, j);
        }
        if (i < right) {
            sort(input, i, right);
        }
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}

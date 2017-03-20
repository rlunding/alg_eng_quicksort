package org.lunding;

import java.util.Arrays;
import java.util.Collections;

/**
 *  http://algs4.cs.princeton.edu/22mergesort/MergeX.java.html
 * Created by lunding on 24/02/2017.
 */
public class Mergesort {

    private int QUICKSORT_CUTOFF;
    private QuickDualPivot quickDualPivot;

    public Mergesort(int QUICKSORT_CUTOFF) {
        this.QUICKSORT_CUTOFF = QUICKSORT_CUTOFF;
        this.quickDualPivot = new QuickDualPivot(50);
    }

    public void sort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        int helper[] = input.clone();
        mergesort(helper, input, 0, input.length-1);
    }

    private void mergesort(int[] helper, int[] input, int left, int right) {
        if (right <= left + QUICKSORT_CUTOFF) {
            //quickDualPivot.sort(input, left, right);
            InsertionSort.optimizedSort(input, left, right);
            return;
        }

        int middle = left + (right - left) / 2;//(left + right) >>> 1;
        mergesort(input, helper, left, middle);
        mergesort(input, helper, middle+1, right);
        if (!(helper[middle+1] < helper[middle])) {
            System.arraycopy(helper, left, input, left, right-left+1);
            return;
        }
        merge(helper, input, left, middle, right);

    }

    private void merge(int[] helper, int input[], int left, int middle, int right) {
        int i = left, j = middle + 1;
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                input[k] = helper[j++];
            } else if (j > right) {
                input[k] = helper[i++];
            } else if (helper[j] < helper[i]) {
                input[k] = helper[j++];
            } else {
                input[k] = helper[i++];
            }
        }
    }
}

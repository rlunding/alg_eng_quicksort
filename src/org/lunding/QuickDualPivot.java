package org.lunding;

/**
 * Source: http://algs4.cs.princeton.edu/23quicksort/QuickDualPivot.java.html
 *
 * Created by lunding on 19/02/2017.
 */
public class QuickDualPivot {

    private int INSERTION_SORT_CUTOFF;

    public QuickDualPivot(int INSERTION_SORT_CUTOFF) {
        this.INSERTION_SORT_CUTOFF = INSERTION_SORT_CUTOFF;
    }

    public void sort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        sort(input, 0, input.length-1);
    }

    public void sort(int[] input, int left, int right) {
        if (right <= left){
            return;
        }

        if (right - left + 1 < INSERTION_SORT_CUTOFF) {
            InsertionSort.optimizedSort(input, left, right);
            return;
        }

        if (input[right] < input[left]) {
            swap(input, left, right);
        }

        int lt = left + 1, gt = right - 1;
        int i = left + 1;
        while (i <= gt) {
            if (input[i] < input[left]) swap(input, lt++, i++);
            else if (input[right] < input[i]) swap(input, i, gt--);
            else i++;
        }
        swap(input, left, --lt);
        swap(input, right, ++gt);

        sort(input, left, lt-1);
        if (input[lt] < input[gt]) sort(input, lt+1, gt-1);
        sort(input, gt+1, right);
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

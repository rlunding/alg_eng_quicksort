package org.lunding;

/**
 * Created by lunding on 16/02/2017.
 */
public class SimpleQuicksort {

    private int INSERTION_SORT_CUTOFF;

    public SimpleQuicksort(int INSERTION_SORT_CUTOFF) {
        this.INSERTION_SORT_CUTOFF = INSERTION_SORT_CUTOFF;
    }

    public void sort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        sort(input, 0, input.length-1);
    }

    public void sort(int[] input, int left, int right) {
        if (right - left < INSERTION_SORT_CUTOFF) {
            InsertionSort.optimizedSort(input, left, right);
            return;
        }

        int i = left;
        int j = right;

        int pivot = input[left + (right - left) / 2];

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

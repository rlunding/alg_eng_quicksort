package org.lunding;

/**
 * Created by lunding on 15/02/2017.
 */
public class InsertionSort {

    private InsertionSort() {
    }


    public static void sort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        sort(input, 0, input.length - 1);
    }

    /**
     * Sort an array with insertion mergesort.
     * https://en.wikipedia.org/wiki/Insertion_sort#Algorithm_for_insertion_sort
     *
     * @param input int array to be sorted
     */
    public static void sort(int[] input, int left, int right) {
        for (int i = left + 1; i < right + 1; ++i) {
            int element = input[i];
            int j = i - 1;

            while (input[j] > element) {
                input[j + 1] = input[j];
                --j;
                if (j == -1) {
                    break;
                }
            }
            input[j + 1] = element;
        }
    }

    public static void optimizedSort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        optimizedSort(input, 0, input.length - 1);
    }


    public static void optimizedSort(int[] input, int left, int right) {
        int n = right + 1;

        int exchanges = 0;
        for (int i = n - 1; i > left + 1; i--) {
            if (input[i] < input[i - 1]) {
                swap(input, i, i - 1);
                exchanges++;
            }
        }
        if (exchanges == 0) return;

        for (int i = left + 3; i < n; i++) {
            int v = input[i];
            int j = i;
            while (v < input[j - 1]) {
                input[j] = input[j-1];
                j--;
            }
            input[j] = v;
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}

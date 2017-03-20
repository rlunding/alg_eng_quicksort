package org.lunding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * http://stackoverflow.com/questions/3466242/multithreaded-merge-sort
 * http://stackoverflow.com/questions/3425126/java-parallelizing-quick-sort-via-multi-threading
 *
 * Created by lunding on 01/03/2017.
 */
public class ParallelQuicksort {

    private static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

    private int INSERTION_SORT_CUTOFF;

    public ParallelQuicksort(int INSERTION_SORT_CUTOFF) {
        this.INSERTION_SORT_CUTOFF = INSERTION_SORT_CUTOFF;
    }

    public void sort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        new ParallelQuicksortHelper(input, 0, input.length-1, input.length/MAX_THREADS).run();
        executor.shutdown();
    }


    private class ParallelQuicksortHelper implements Runnable {

        private int partitionCutoff;
        private int input[];
        private int left;
        private int right;

        public ParallelQuicksortHelper(int[] input, int left, int right, int partitionCutoff) {
            this.input = input;
            this.left = left;
            this.right = right;
            this.partitionCutoff = partitionCutoff;
        }

        @Override
        public void run() {
            sort(input, left, right);
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
            if (right - left >= partitionCutoff) {
                Future future1 = null;
                Future future2 = null;
                if (left < j) {
                    ParallelQuicksortHelper help = new ParallelQuicksortHelper(input, left, j, partitionCutoff);
                    future1 = executor.submit(help);
                }
                if (i < right) {
                    ParallelQuicksortHelper help = new ParallelQuicksortHelper(input, i, right, partitionCutoff);
                    future2 = executor.submit(help);
                }

                try {if (future1 != null) {future1.get();}}catch(Exception e){e.printStackTrace();}
                try {if (future2 != null) {future2.get();}}catch(Exception e){e.printStackTrace();}
            } else {
                if (left < j) {
                    sort(input, left, j);
                }
                if (i < right) {
                    sort(input, i, right);
                }
            }
        }

        private void swap(int[] input, int i, int j) {
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
    }
}

package org.lunding;

import java.util.Collections;

/**
 * Created by lunding on 15/02/2017.
 */
public class JRE {

    private int INSERTION_SORT_CUTOFF;
    private int TERTILE_X;
    private int TERTILE_Y;

    public JRE(int INSERTION_SORT_CUTOFF, int TERTILE_X, int TERTILE_Y) {
        this.INSERTION_SORT_CUTOFF = INSERTION_SORT_CUTOFF;
        this.TERTILE_X = TERTILE_X;
        this.TERTILE_Y = TERTILE_Y;
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
        int s7 = (length >> 3) + (length >> 6) + 1;
        int e3 = (left + right) >>> 1;
        int e2 = e3 - s7;
        int e1 = e2 - s7; if (length == 8) ++e1;
        int e4 = e3 + s7; int e5 = e4 + s7;

        // Sort these elements using insertion mergesort
        if (input[e2] < input[e1]) { int t = input[e2]; input[e2] = input[e1]; input[e1] = t; }

        if (input[e3] < input[e2]) { int t = input[e3]; input[e3] = input[e2]; input[e2] = t;
            if (t < input[e1]) { input[e2] = input[e1]; input[e1] = t; }
        }
        if (input[e4] < input[e3]) { int t = input[e4]; input[e4] = input[e3]; input[e3] = t;
            if (t < input[e2]) { input[e3] = input[e2]; input[e2] = t;
                if (t < input[e1]) { input[e2] = input[e1]; input[e1] = t; }
            }
        }
        if (input[e5] < input[e4]) { int t = input[e5]; input[e5] = input[e4]; input[e4] = t;
            if (t < input[e3]) { input[e4] = input[e3]; input[e3] = t;
                if (t < input[e2]) { input[e3] = input[e2]; input[e2] = t;
                    if (t < input[e1]) { input[e2] = input[e1]; input[e1] = t; }
                }
            }
        }

        int tertiles[] = {e1, e2, e3, e4, e5};
        int pIndex = tertiles[TERTILE_X], qIndex = tertiles[TERTILE_Y]; // tertiles
        int l = left + 1, g = right - 1, k = l;
        int p = input[pIndex]; input[pIndex] = input[left];
        int q = input[qIndex]; input[qIndex] = input[right];

        while (k <= g) {
            int ak = input[k];
            if (ak < p) {
                input[k] = input[l]; input[l] = ak; ++l;
            } else if (ak >= q) {
                while (input[g] > q && k < g) --g;
                if (input[g] < p) {
                    input[k] = input[l]; input[l] = input[g]; ++l;
                } else {
                    input[k] = input[g];
                }
                input[g] = ak; --g;
            }
            ++k;
        }
        --l; ++g;

        // Swap pivots into their positions
        input[left] = input[l]; input[l] = p;
        input[right] = input[g]; input[g] = q;
        sort(input, left, l - 1);
        sort(input, g + 1, right);
        sort(input, l, g);

    }
}

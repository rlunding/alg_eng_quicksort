package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;
import org.lunding.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 100, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Thread)
public class BenchLowInput {

    //@Param({"5", "10", "15", "20", "25", "30", "40", "50", "60", "70", "80", "90", "100", "120", "140", "160", "180", "200", "250", "300", "350", "400", "450", "500"})
    @Param({"600", "700", "800", "900", "1000", "1250", "1500", "1750", "2000", "2500", "3000"})
    private int elements;

    @Param({"true", "false"})
    private boolean completelyRandom;

    private int numbers[];


    @Setup(Level.Invocation)
    public void prepare() {
        if (completelyRandom) {
            numbers = DataGenerator.generateRandomNumbers(elements);
        } else {
            numbers = DataGenerator.generateAlmostSortedNumbers(elements);
        }
    }

    @Benchmark
    public void InsertionSort(Blackhole blackhole) {
        InsertionSort.optimizedSort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void QuickSort(Blackhole blackhole) {
        (new QuickDualPivot(0)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void MergeSort(Blackhole blackhole) {
        (new Mergesort(0)).sort(numbers);
        blackhole.consume(numbers);
    }
}

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
@Warmup(iterations = 20, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 40, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Thread)
public class BenchLowInput {

    @Param({"5", "10", "15", "20", "25", "30", "40", "50", "60", "70", "80", "90", "100", "120", "140", "160", "180", "200", "250", "300", "350", "400", "450", "500"})
    private int elements;
    private int numbers[];


    @Setup(Level.Invocation)
    public void prepare() {
        numbers = DataGenerator.generateRandomNumbers(elements);
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

    @Benchmark
    public void JRE(Blackhole blackhole) {
        (new JRE(10, 0, 2)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void skewedQuicksort(Blackhole blackhole) {
        (new SkewedPivotQuicksort(10, 1)).sort(numbers);
        blackhole.consume(numbers);
    }

}

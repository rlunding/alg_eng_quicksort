package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.lunding.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 100, time = 50, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 100, time = 50, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Thread)
public class BenchInsertionSort {

    @Param({"4", "8", "16", "32", "64", "128", "256"})
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
    public void insertionSort(Blackhole blackhole) {
        InsertionSort.sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void optimizedInsertionSort(Blackhole blackhole) {
        InsertionSort.optimizedSort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void javaInsertionSort(Blackhole blackhole) {
        InsertionSort.javaSort(numbers);
        blackhole.consume(numbers);
    }

}

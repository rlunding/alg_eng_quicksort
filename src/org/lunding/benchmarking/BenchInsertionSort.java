package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.lunding.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class BenchInsertionSort {

    private int numbers[];

    @Setup(Level.Invocation)
    public void prepare() {
        numbers = DataGenerator.generateRandomNumbers(25000);
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

}

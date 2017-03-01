package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;

import org.lunding.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class BenchMergesort {

    @Param({"100000", "250000", "500000", "1000000", "2000000"})
    private int elements;
    private int numbers[];


    @Setup(Level.Invocation)
    public void prepare() {
        numbers = DataGenerator.generateRandomNumbers(elements);
    }

    @Benchmark
    public void Mergesort_00(Blackhole blackhole) {
        (new Mergesort(0)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void Mergesort_10(Blackhole blackhole) {
        (new Mergesort(10)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void Mergesort_20(Blackhole blackhole) {
        (new Mergesort(20)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void Mergesort_30(Blackhole blackhole) {
        (new Mergesort(30)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void Mergesort_40(Blackhole blackhole) {
        (new Mergesort(40)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void Mergesort_50(Blackhole blackhole) {
        (new Mergesort(50)).sort(numbers);
        blackhole.consume(numbers);
    }

}

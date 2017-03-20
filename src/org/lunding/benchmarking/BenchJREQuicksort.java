package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;

import org.lunding.DataGenerator;
import org.lunding.JRE;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 250, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 250, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class BenchJREQuicksort {

    @Param({"4000000"})
    private int elements;

    @Param({"10"})
    private int INSERTION_SORT_CUTOFF;

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
    public void simpleQuicksort_1_2(Blackhole blackhole) {
        (new JRE(INSERTION_SORT_CUTOFF, 0, 1)).sort(numbers);
        blackhole.consume(numbers);
    }


    @Benchmark
    public void simpleQuicksort_1_3(Blackhole blackhole) {
        (new JRE(INSERTION_SORT_CUTOFF, 0, 2)).sort(numbers);
        blackhole.consume(numbers);
    }


    @Benchmark
    public void simpleQuicksort_1_4(Blackhole blackhole) {
        (new JRE(INSERTION_SORT_CUTOFF, 0, 3)).sort(numbers);
        blackhole.consume(numbers);
    }


    @Benchmark
    public void simpleQuicksort_2_3(Blackhole blackhole) {
        (new JRE(INSERTION_SORT_CUTOFF, 1, 2)).sort(numbers);
        blackhole.consume(numbers);
    }


    @Benchmark
    public void simpleQuicksort_2_4(Blackhole blackhole) {
        (new JRE(INSERTION_SORT_CUTOFF, 1, 3)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void simpleQuicksort_2_5(Blackhole blackhole) {
        (new JRE(INSERTION_SORT_CUTOFF, 1, 4)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void simpleQuicksort_3_4(Blackhole blackhole) {
        (new JRE(INSERTION_SORT_CUTOFF, 2, 3)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void simpleQuicksort_3_5(Blackhole blackhole) {
        (new JRE(INSERTION_SORT_CUTOFF, 2, 4)).sort(numbers);
        blackhole.consume(numbers);
    }
}

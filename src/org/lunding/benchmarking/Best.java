package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;
import org.lunding.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class Best {

    //@Param({"100000", "250000", "500000", "1000000", "2000000", "4000000"})
    @Param({"512", "1024", "2048", "4096", "8192", "16384", "32768", "65536", "131072", "262144", "524288", "1048576", "2097152", "4194304"})
    //@Param({"2000000", "3000000", "4000000"})
    private int elements;

    @Param({"true", "false"})
    //@Param({"false"})
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

    /*
    @Benchmark
    public void simpleQuicksort(Blackhole blackhole) {
        (new SimpleQuicksort(40)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void SkewedPivotQuicksort(Blackhole blackhole) {
        (new SkewedPivotQuicksort(20, 1)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void JREQuicksort(Blackhole blackhole) {
        (new JRE(20, 1, 3)).sort(numbers);
        blackhole.consume(numbers);
    }

*/
    @Benchmark
    public void simpleQuicksort_1_3(Blackhole blackhole) {
        (new JRE(50, 0, 2)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void QuickDualPivot(Blackhole blackhole) {
        (new QuickDualPivot(50)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void Mergesort(Blackhole blackhole) {
        (new Mergesort(250)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void buildInSort(Blackhole blackhole) {
        Arrays.sort(numbers);
        blackhole.consume(numbers);
    }
}

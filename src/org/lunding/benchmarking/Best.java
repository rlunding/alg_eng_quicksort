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
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class Best {

    @Param({"100000", "250000", "500000", "1000000", "2000000"})
    private int elements;
    private int numbers[];


    @Setup(Level.Invocation)
    public void prepare() {
        numbers = DataGenerator.generateRandomNumbers(elements);
    }

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

    @Benchmark
    public void QuickDualPivot(Blackhole blackhole) {
        (new QuickDualPivot(0)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void Mergesort(Blackhole blackhole) {
        (new Mergesort(0)).sort(numbers);
        blackhole.consume(numbers);
    }

    @Benchmark
    public void buildInSort(Blackhole blackhole) {
        Arrays.sort(numbers);
        blackhole.consume(numbers);
    }
}

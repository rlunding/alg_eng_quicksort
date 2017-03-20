package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.lunding.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class BenchDualPivotQuicksort {

    @Param({"100000", "250000", "500000", "1000000", "2000000", "3000000", "4000000"})
    private int elements;

    @Param({"0", "10", "20", "30", "40", "50", "60"})
    private int cutoff;

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
    public void dualQuicksort(Blackhole blackhole) {
        (new QuickDualPivot(cutoff)).sort(numbers);
        blackhole.consume(numbers);
    }
}

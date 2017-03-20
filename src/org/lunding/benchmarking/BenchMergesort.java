package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;

import org.lunding.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 100, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Thread)
public class BenchMergesort {

    //@Param({"100000", "250000", "500000", "1000000", "2000000"})
    @Param({"32768", "65536", "131072", "262144", "524288", "1048576", "2097152"}) //, "4194304"
    private int elements;

    @Param({"0", "50", "100", "150", "200", "250", "300", "350"})
    private int cutoff;

    private int numbers[];


    @Setup(Level.Invocation)
    public void prepare() {
        numbers = DataGenerator.generateRandomNumbers(elements);
    }

    @Benchmark
    public void Mergesort(Blackhole blackhole) {
        (new Mergesort(cutoff)).sort(numbers);
        blackhole.consume(numbers);
    }



}

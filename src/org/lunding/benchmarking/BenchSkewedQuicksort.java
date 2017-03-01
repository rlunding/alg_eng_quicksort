package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;

import org.lunding.DataGenerator;
import org.lunding.SkewedPivotQuicksort;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class BenchSkewedQuicksort {

    @State(Scope.Thread)
    public static class NumberState {
        int numbers[];

        @Setup(Level.Invocation)
        public void prepare() {
            numbers = DataGenerator.generateRandomNumbers(2000000);
        }
    }

    @Benchmark
    public void skewedQuicksort10_0(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(10, 0)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort20_0(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(20, 0)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort30_0(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(30, 0)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort40_0(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(40, 0)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort50_0(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(50, 0)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort60_0(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(60, 0)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    /*

     */

    @Benchmark
    public void skewedQuicksort10_1(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(10, 1)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort20_1(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(20, 1)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort30_1(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(30, 1)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort40_1(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(40, 1)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort50_1(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(50, 1)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort60_1(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(60, 1)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    /*

     */

    @Benchmark
    public void skewedQuicksort10_2(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(10, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort20_2(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(20, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort30_2(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(30, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort40_2(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(40, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort50_2(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(50, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort60_2(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(60, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    /*

     */

    @Benchmark
    public void skewedQuicksort10_3(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(10, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort20_3(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(20, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort30_3(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(30, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort40_3(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(40, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort50_3(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(50, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort60_3(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(60, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    /*

     */

    @Benchmark
    public void skewedQuicksort10_4(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(10, 4)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort20_4(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(20, 4)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort30_4(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(30, 4)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort40_4(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(40, 4)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort50_4(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(50, 4)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void skewedQuicksort60_4(NumberState state, Blackhole blackhole) {
        (new SkewedPivotQuicksort(60, 4)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }
}

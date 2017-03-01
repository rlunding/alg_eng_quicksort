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
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class BenchJREQuicksort {

    @State(Scope.Thread)
    public static class NumberState {
        int numbers[];

        @Setup(Level.Invocation)
        public void prepare() {
            numbers = DataGenerator.generateRandomNumbers(2000000);
        }
    }

    @Benchmark
    public void simpleQuicksort20_1_2(NumberState state, Blackhole blackhole) {
        (new JRE(20, 0, 1)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort40_1_2(NumberState state, Blackhole blackhole) {
        (new JRE(40, 0, 1)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort60_1_2(NumberState state, Blackhole blackhole) {
        (new JRE(60, 0, 1)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort20_1_3(NumberState state, Blackhole blackhole) {
        (new JRE(20, 0, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort40_1_3(NumberState state, Blackhole blackhole) {
        (new JRE(40, 0, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort60_1_3(NumberState state, Blackhole blackhole) {
        (new JRE(60, 0, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort20_1_4(NumberState state, Blackhole blackhole) {
        (new JRE(20, 0, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort40_1_4(NumberState state, Blackhole blackhole) {
        (new JRE(40, 0, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort60_1_4(NumberState state, Blackhole blackhole) {
        (new JRE(60, 0, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort20_2_3(NumberState state, Blackhole blackhole) {
        (new JRE(20, 1, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort40_2_3(NumberState state, Blackhole blackhole) {
        (new JRE(40, 1, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort60_2_3(NumberState state, Blackhole blackhole) {
        (new JRE(60, 1, 2)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort20_2_4(NumberState state, Blackhole blackhole) {
        (new JRE(20, 1, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort40_2_4(NumberState state, Blackhole blackhole) {
        (new JRE(40, 1, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort60_2_4(NumberState state, Blackhole blackhole) {
        (new JRE(60, 1, 3)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort20_3_5(NumberState state, Blackhole blackhole) {
        (new JRE(20, 2, 4)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort40_3_5(NumberState state, Blackhole blackhole) {
        (new JRE(40, 2, 4)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort60_3_5(NumberState state, Blackhole blackhole) {
        (new JRE(60, 2, 4)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }


}

package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;

import org.lunding.DataGenerator;
import org.lunding.SimpleQuicksort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class BenchSimpleQuicksort {

    @State(Scope.Thread)
    public static class NumberState {
        int numbers[];

        @Setup(Level.Invocation)
        public void prepare() {
            numbers = DataGenerator.generateRandomNumbers(2000000);
        }
    }

    @Benchmark
    public void simpleQuicksort00(NumberState state, Blackhole blackhole) {
        (new SimpleQuicksort(0)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort05(NumberState state, Blackhole blackhole) {
        (new SimpleQuicksort(5)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort10(NumberState state, Blackhole blackhole) {
        (new SimpleQuicksort(10)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort20(NumberState state, Blackhole blackhole) {
        (new SimpleQuicksort(20)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort30(NumberState state, Blackhole blackhole) {
        (new SimpleQuicksort(30)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort40(NumberState state, Blackhole blackhole) {
        (new SimpleQuicksort(40)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort50(NumberState state, Blackhole blackhole) {
        (new SimpleQuicksort(50)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort60(NumberState state, Blackhole blackhole) {
        (new SimpleQuicksort(60)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void simpleQuicksort70(NumberState state, Blackhole blackhole) {
        (new SimpleQuicksort(70)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

}

package org.lunding.benchmarking;

//import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.lunding.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class BenchDualPivotQuicksort {

    @State(Scope.Thread)
    public static class NumberState {
        int numbers[];

        @Setup(Level.Invocation)
        public void prepare() {
            numbers = DataGenerator.generateRandomNumbers(2000000);//new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        }
    }

    @Benchmark
    public void dualQuicksort00(NumberState state, Blackhole blackhole) {
        (new QuickDualPivot(0)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void dualQuicksort10(NumberState state, Blackhole blackhole) {
        (new QuickDualPivot(10)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void dualQuicksort20(NumberState state, Blackhole blackhole) {
        (new QuickDualPivot(20)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void dualQuicksort30(NumberState state, Blackhole blackhole) {
        (new QuickDualPivot(30)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void dualQuicksort40(NumberState state, Blackhole blackhole) {
        (new QuickDualPivot(40)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void dualQuicksort50(NumberState state, Blackhole blackhole) {
        (new QuickDualPivot(50)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void dualQuicksort60(NumberState state, Blackhole blackhole) {
        (new QuickDualPivot(60)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

    @Benchmark
    public void dualQuicksort70(NumberState state, Blackhole blackhole) {
        (new QuickDualPivot(70)).sort(state.numbers);
        blackhole.consume(state.numbers);
    }

}

# Algorithm Engineering - Improving Quicksort in Java
This project is all about optimizing java's build in Quicksort.

To run this project you need Java 1.8 and ant + ivy. To see the available targets type:
```bash
$ ant help
```


## JMH
We have used the JMH-framework to do benchmarks. A benchmark will look something like this.
```Java
@Benchmark
public void benchmark() {
    //Code to benchmark
}
```
All benchmarks are located in the Benchmark-folder in the source tree.

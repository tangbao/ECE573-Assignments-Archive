/*
    Measure running time in nanoseconds
    Inspired by the Stopwatch.java from Princeton
    https://introcs.cs.princeton.edu/java/stdlib/Stopwatch.java.html
    Written by Zhongze Tang for DSA HW
 */

public class NanoTimer {
    private long start;

    NanoTimer(){
        start = System.nanoTime();
    }

    public long calc(){
        long end = System.nanoTime();
        return (end - start);
    }
}

package cn.com.bjtu.algorithm.analysis;

import com.common.Examination;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

/**
 * @author [您的名字]
 * @date 2024-09-12 13:11
 * @description [类的简要描述]
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class TestBenchmark01 {
    @Benchmark
    public void cal01() {
        int value = (int) (Math.random() * (256 - 1)) + 1;
        Test01.cal01(value);
    }

    public static void main(String[] args) {

    }
}
